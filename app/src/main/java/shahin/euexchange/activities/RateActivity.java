package shahin.euexchange.activities;

import android.app.LoaderManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shahin.euexchange.R;
import shahin.euexchange.models.Country;
import shahin.euexchange.models.CountryResponse;
import shahin.euexchange.models.Rates;
import shahin.euexchange.background.CurrencyAsyncTaskLoader;
import shahin.euexchange.networking.ApiRetrofitInterface;
import shahin.euexchange.networking.RetrofitApiClient;
import shahin.euexchange.ui.RateRecyclerAdapter;
import shahin.euexchange.ui.RecyclerViewTouchListener;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;
import static shahin.euexchange.utilities.Constants.AD_ID;
import static shahin.euexchange.utilities.Constants.AMOUNT_STATE_KEY;
import static shahin.euexchange.utilities.Constants.API_ACCESS_KEY;
import static shahin.euexchange.utilities.Constants.BASE_URL;
import static shahin.euexchange.utilities.Constants.INTENT_COUNTRY_KEY;
import static shahin.euexchange.utilities.Constants.LAYOUT_MANAGER_STATE_KEY;
import static shahin.euexchange.utilities.Constants.LOADER_ID;
import static shahin.euexchange.utilities.Constants.PAR_ACCESS_KEY;
import static shahin.euexchange.utilities.Constants.SEARCH_ON_STATE_KEY;
import static shahin.euexchange.utilities.Constants.setAdditionalContent;

//Created by Mohamed Shahin on 01/08/2017.

public class RateActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Rates>>, RateRecyclerAdapter.CurrencyAdapterListener{

    public static final String LOG_TAG = RateActivity.class.getSimpleName();

    @BindView(R.id.tv_latest_update) TextView tv_latest_update;
    @BindView(R.id.rv_rates) RecyclerView rv_rates;
    @BindView(R.id.iv_welcome) ImageView iv_welcome;
    @BindView(R.id.pb_loading) ProgressBar pb_loading;
    @BindView(R.id.adView) AdView adView;
    @BindView(R.id.et_search) EditText et_search;


    private RateRecyclerAdapter rateRecyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    private String latestUpdate;
    private List<Rates> ratesList;

    private boolean searchOn = false;

    private double euroAmount;

    private CountryResponse countryResponse;

    private Parcelable layoutManagerState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDialog();
            }
        });

        MobileAds.initialize(this, AD_ID);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        ratesList = new ArrayList<>();

        //RecyclerView Setup
        linearLayoutManager = new LinearLayoutManager(this);
        rv_rates.setLayoutManager(linearLayoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        rv_rates.addItemDecoration(decoration);
        rateRecyclerAdapter = new RateRecyclerAdapter(this, ratesList, this);
        rv_rates.setAdapter(rateRecyclerAdapter);


        rv_rates.setVisibility(View.INVISIBLE);
        pb_loading.setVisibility(View.INVISIBLE);
        et_search.setVisibility(View.GONE);


        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                rateRecyclerAdapter.getFilter().filter(editable);
            }
        });

        getLatestRates();
        loadCountries();

    }


    @Override
    public Loader<List<Rates>> onCreateLoader(int id, Bundle args) {
        Log.i(LOG_TAG, "TEST: onCreateLoader() called...");

        return new CurrencyAsyncTaskLoader(this, buildURL());
    }

    @Override
    public void onLoadFinished(Loader<List<Rates>> loader, List<Rates> rates) {
        Log.i(LOG_TAG, "TEST: onLoadFinished() called...");

        pb_loading.setVisibility(View.INVISIBLE);

        if (rates != null && !rates.isEmpty()) {
            ratesList = rates;
            latestUpdate = ratesList.get(0).getLatestDate();
            tv_latest_update.setText(latestUpdate);
            rateRecyclerAdapter = new RateRecyclerAdapter(this, ratesList, this);
            rv_rates.setAdapter(rateRecyclerAdapter);
            linearLayoutManager.onRestoreInstanceState(layoutManagerState);
            setAdditionalContent(ratesList);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Rates>> loader) {
        Log.i(LOG_TAG, "TEST: onLoaderReset() called...");
    }

    private String buildURL(){
        Uri baseUri = Uri.parse(BASE_URL);
        Uri.Builder builder = baseUri.buildUpon();
        builder.appendQueryParameter(PAR_ACCESS_KEY, API_ACCESS_KEY);
        return builder.build().toString();
    }

    private void getLatestRates() {

        iv_welcome.setVisibility(View.INVISIBLE);
        rv_rates.setVisibility(View.INVISIBLE);

        pb_loading.setVisibility(View.VISIBLE);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            iv_welcome.setVisibility(View.INVISIBLE);
            rv_rates.setVisibility(View.VISIBLE);
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(LOADER_ID, null, RateActivity.this);
        } else {
            pb_loading.setVisibility(View.INVISIBLE);
            rv_rates.setVisibility(View.INVISIBLE);
            iv_welcome.setVisibility(View.VISIBLE);
            snackBarIndefinite(getString(R.string.fail_message), getString(R.string.connect_refresh), getString(R.string.done));
            tv_latest_update.setText(R.string.not_applicable);
        }
    }

    private void setInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.str_the_mount_you_wish);

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(input);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                euroAmount = Double.parseDouble(input.getText().toString());
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rates, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_refresh_rates:
                Toast.makeText(getApplicationContext(), R.string.str_updating_the_rates, Toast.LENGTH_SHORT).show();
                getLatestRates();
                return true;

            case R.id.action_report_suggest:
                sendEmail(getString(R.string.str_suggest_report));
                return true;

            case R.id.action_search:

                if(searchOn){
                    et_search.setVisibility(View.GONE);
                    searchOn = false;
                }else{
                    et_search.setVisibility(View.VISIBLE);
                    searchOn = true;
                }
                return true;

            case R.id.action_country:
                startActivity(new Intent(RateActivity.this, CountryActivity.class));
                return true;

            case R.id.action_favorite_list:
                startActivity(new Intent(RateActivity.this, FavoriteActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void sendEmail(String text) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"M7edshin@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, text);
        i.putExtra(Intent.EXTRA_TEXT, "Your Message");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(RateActivity.this, R.string.str_no_emails_clients_installed, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onCurrencySelected(Rates rates) {
        double rate = Double.parseDouble(rates.getRate());
        double result = euroAmount * rate;
        String roundedResult = String.format(Locale.ENGLISH, "%.2f", result);
        Toast.makeText(getApplicationContext(), roundedResult + " " + rates.getSymbol(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCurrencyLongClickListener(Rates rates) {
        String currency = rates.getSymbol();
        for(Country country : countryResponse.getCountryList()){
            if (country.getCurrencyCode().equalsIgnoreCase(currency)){
                Intent intent = new Intent(RateActivity.this, DetailsActivity.class);
                intent.putExtra(INTENT_COUNTRY_KEY, country);
                startActivity(intent);
                break;
            }
        }
        snackBarShort(getString(R.string.not_available_as_country));
    }

    /**
     * Perform network call and load the countries
     */

    public void loadCountries() {
        ApiRetrofitInterface apiRetrofitInterface = RetrofitApiClient.getClient().create(ApiRetrofitInterface.class);
        Call<CountryResponse> call = apiRetrofitInterface.getCountryResponse();
        call.enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {

                if(response.isSuccessful()){
                    countryResponse = response.body();
                }else{
                    int statusCode = response.code();
                    snackBarShort(getString(R.string.temp_message) + " " + String.valueOf(statusCode));
                }

            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {
                snackBarIndefinite(getString(R.string.fail_message), getString(R.string.connect_refresh), getString(R.string.done));
            }
        });
    }

    private void snackBarIndefinite(String message, String action, final String actionMessage){
        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), message, Snackbar.LENGTH_INDEFINITE)
                .setAction(action, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(findViewById(android.R.id.content), actionMessage, Snackbar.LENGTH_SHORT);
                        getLatestRates();
                        loadCountries();
                    }
                });

        snackbar.show();
    }

    private void snackBarShort(String message){
        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        if (linearLayoutManager != null) {
                layoutManagerState = linearLayoutManager.onSaveInstanceState();
                outState.putParcelable(LAYOUT_MANAGER_STATE_KEY, layoutManagerState);
        }
        outState.putBoolean(SEARCH_ON_STATE_KEY, searchOn);
        outState.putDouble(AMOUNT_STATE_KEY, euroAmount);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        searchOn = savedInstanceState.getBoolean(SEARCH_ON_STATE_KEY);
        if(searchOn){
            et_search.setVisibility(View.VISIBLE);
        }else {
            et_search.setVisibility(View.GONE);
        }
        euroAmount = savedInstanceState.getDouble(AMOUNT_STATE_KEY);
    }

}
