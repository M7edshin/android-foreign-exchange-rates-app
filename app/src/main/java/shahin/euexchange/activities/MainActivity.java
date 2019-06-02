package shahin.euexchange.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import shahin.euexchange.R;
import shahin.euexchange.background.CurrencyAsyncTaskLoader;
import shahin.euexchange.models.Rate;
import shahin.euexchange.ui.RateRecyclerAdapter;

import static androidx.recyclerview.widget.DividerItemDecoration.VERTICAL;
import static shahin.euexchange.utilities.Constants.API_ACCESS_KEY;
import static shahin.euexchange.utilities.Constants.BASE_URL;
import static shahin.euexchange.utilities.Constants.LOADER_ID;
import static shahin.euexchange.utilities.Constants.PAR_ACCESS_KEY;
import static shahin.euexchange.utilities.Constants.accessPrivacyPolicy;
import static shahin.euexchange.utilities.Constants.setAdditionalCountryContent;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Rate>>, RateRecyclerAdapter.CurrencyAdapterListener {

    //General Declaration
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    //Views Declaration
    @BindView(R.id.tv_latest_update)
    TextView tv_latest_update;
    @BindView(R.id.rv_rates)
    RecyclerView rv_rates;
    @BindView(R.id.iv_welcome)
    ImageView iv_welcome;
    @BindView(R.id.pb_loading)
    ProgressBar pb_loading;
    @BindView(R.id.adView)
    AdView adView;
    @BindView(R.id.et_search)
    EditText et_search;
    private boolean searchOn = false;
    private List<Rate> rateList;
    private double euroAmount;

    //Member Declaration
    private RateRecyclerAdapter rateRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        //Initialize Views
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> setInputDialog());

        MobileAds.initialize(this, getString(R.string.admob_app_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //Initialize Members
        rateList = new ArrayList<>();

        //RecyclerView Setup
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_rates.setLayoutManager(linearLayoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        rv_rates.addItemDecoration(decoration);
        rateRecyclerAdapter = new RateRecyclerAdapter(this, rateList, this);
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
            case R.id.action_search:
                if (searchOn) {
                    et_search.setVisibility(View.GONE);
                    searchOn = false;
                } else {
                    et_search.setVisibility(View.VISIBLE);
                    searchOn = true;
                }
                return true;
            case R.id.action_policy:
                accessPrivacyPolicy(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<List<Rate>> onCreateLoader(int id, Bundle args) {
        Log.i(LOG_TAG, "MyLogs: onCreateLoader() called...");
        return new CurrencyAsyncTaskLoader(this, buildURL());
    }

    @Override
    public void onLoadFinished(Loader<List<Rate>> loader, List<Rate> rates) {
        Log.i(LOG_TAG, "MyLogs: onLoadFinished() called...");

        pb_loading.setVisibility(View.INVISIBLE);

        if (rates != null && !rates.isEmpty()) {
            rateList = rates;
            String latestUpdate = rateList.get(0).getLatestDate();
            tv_latest_update.setText(String.format("%s%s", getString(R.string.up_to_date), latestUpdate));
            rateRecyclerAdapter = new RateRecyclerAdapter(this, rateList, this);
            rv_rates.setAdapter(rateRecyclerAdapter);
            setAdditionalCountryContent(rateList);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Rate>> loader) {
        Log.i(LOG_TAG, "MyLogs: onLoaderReset() called...");
    }

    private String buildURL() {
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
            LoaderManager.getInstance(this).initLoader(LOADER_ID, null, MainActivity.this);
        } else {
            pb_loading.setVisibility(View.INVISIBLE);
            rv_rates.setVisibility(View.INVISIBLE);
            iv_welcome.setVisibility(View.VISIBLE);
            tv_latest_update.setText(R.string.not_applicable);
        }
    }

    private void setInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.str_the_mount_you_wish);

        final EditText input = new EditText(getApplicationContext());
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(input);

        builder.setPositiveButton(R.string.ok, (dialog, which) -> {
            if (input.getText().toString().equals("")) {
                snackBarShort(getString(R.string.no_amount_inserted));
            } else {
                euroAmount = Double.parseDouble(input.getText().toString());
            }
        });
        builder.setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());

        builder.show();
    }

    @Override
    public void onCurrencySelected(Rate rates) {
        double rate = Double.parseDouble(rates.getRate());
        double result = euroAmount * rate;
        String roundedResult = String.format(Locale.ENGLISH, "%.2f", result);
        Snackbar snackbar =
                Snackbar.make(rv_rates, "Total: " + roundedResult + " " + rates.getSymbol(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void onCurrencyLongClickListener(Rate rate) {
        String details = "Country: " + rate.getCountry() +
                "\nRate (€1 = " + rate.getRate() + ")";
        Toast.makeText(getApplicationContext(),details,Toast.LENGTH_LONG).show();
    }

    private void snackBarShort(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}
