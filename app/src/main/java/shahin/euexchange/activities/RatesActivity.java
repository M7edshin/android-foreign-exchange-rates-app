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
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import shahin.euexchange.R;
import shahin.euexchange.models.Rates;
import shahin.euexchange.background.CurrencyAsyncTaskLoader;
import shahin.euexchange.ui.RateRecyclerAdapter;
import shahin.euexchange.ui.RecyclerViewTouchListener;

import static shahin.euexchange.utilities.Constants.API_ACCESS_KEY;
import static shahin.euexchange.utilities.Constants.BASE_URL;
import static shahin.euexchange.utilities.Constants.LOADER_ID;
import static shahin.euexchange.utilities.Constants.PAR_ACCESS_KEY;
import static shahin.euexchange.utilities.Constants.setAdditionalContent;

//Created by Mohamed Shahin on 01/08/2017.

public class RatesActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Rates>>{

    public static final String LOG_TAG = RatesActivity.class.getSimpleName();

    @BindView(R.id.tv_latest_update) TextView tv_latest_update;
    @BindView(R.id.rv_rates) RecyclerView rv_rates;
    @BindView(R.id.iv_empty) ImageView iv_empty;
    @BindView(R.id.pb_loading) ProgressBar pb_loading;
    @BindView(R.id.adView) AdView adView;
    @BindView(R.id.et_search) EditText et_search;


    private RateRecyclerAdapter rateRecyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    private String latestUpdate;
    private List<Rates> ratesList;

    private boolean searchOn;

    private double euroAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);
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

        et_search.setVisibility(View.GONE);

        //RecyclerView Setup
        linearLayoutManager = new LinearLayoutManager(this);
        rv_rates.setLayoutManager(linearLayoutManager);
        rv_rates.setVisibility(View.INVISIBLE);

        pb_loading.setVisibility(View.INVISIBLE);

        getLatestRates();

        rv_rates.addOnItemTouchListener(new RecyclerViewTouchListener(this, rv_rates, new RecyclerViewTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Rates rates = ratesList.get(position);
                double rate = Double.parseDouble(rates.getRate());
                double result = euroAmount * rate;
                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

    }

    private void filter(String text){
        List<Rates> temporaryList = new ArrayList<>();
        for(Rates r: ratesList){
            if(r.getCurrency().toLowerCase().contains(text.toLowerCase())){
                temporaryList.add(r);
            }
        }
        rateRecyclerAdapter.updateList(temporaryList);
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
            rateRecyclerAdapter = new RateRecyclerAdapter(ratesList);
            rv_rates.setAdapter(rateRecyclerAdapter);
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

        iv_empty.setVisibility(View.INVISIBLE);
        rv_rates.setVisibility(View.INVISIBLE);

        pb_loading.setVisibility(View.VISIBLE);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            iv_empty.setVisibility(View.INVISIBLE);
            rv_rates.setVisibility(View.VISIBLE);
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(LOADER_ID, null, RatesActivity.this);
        } else {
            pb_loading.setVisibility(View.INVISIBLE);
            rv_rates.setVisibility(View.INVISIBLE);
            iv_empty.setVisibility(View.VISIBLE);
        }
    }

    private void setInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.str_the_mount_you_wish);

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(input);

        // Set up the buttons
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
            Toast.makeText(RatesActivity.this, R.string.str_no_emails_clients_installed, Toast.LENGTH_SHORT).show();
        }
    }

}
