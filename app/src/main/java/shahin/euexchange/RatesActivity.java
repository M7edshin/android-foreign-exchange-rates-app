package shahin.euexchange;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatesActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Currency> {

    private TextView tvLatestDate, tvRates;
    private ProgressBar loading_spinner;
    private Button btnGetRates;

    public static final String LOG_TAG = RatesActivity.class.getSimpleName();

    private static final String CURRENCY_RATES_REQUEST_URL = "http://api.fixer.io/latest";

    private static final int RATES_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tvLatestDate = (TextView)findViewById(R.id.tvLatestDate);
        tvRates = (TextView)findViewById(R.id.tvRates);
        loading_spinner = (ProgressBar)findViewById(R.id.loading_spinner);
        btnGetRates = (Button)findViewById(R.id.btnGetRates);

        tvLatestDate.setVisibility(View.INVISIBLE);
        tvRates.setVisibility(View.INVISIBLE);

        /**
         * Get the rates
         */
        btnGetRates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get a reference to the ConnectivityManager to check state of network connectivity
                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                // Get details on the currently active default data network
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if(networkInfo != null && networkInfo.isConnected()){
                    // Get a reference to the LoaderManager, in order to interact with loaders
                    LoaderManager loaderManager = getLoaderManager();
                    // Initialize the loader. Pass in the int ID constant defined above and pass in null for
                    // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
                    // because this activity implements the LoaderCallbacks interface).
                    loaderManager.initLoader(RATES_LOADER_ID, null, RatesActivity.this);

                    tvLatestDate.setVisibility(View.VISIBLE);
                    tvRates.setVisibility(View.VISIBLE);
                    btnGetRates.setVisibility(View.INVISIBLE);
                }else{
                    Toast.makeText(getApplicationContext(),"Turn on your WiFi or data for connection then try again", Toast.LENGTH_LONG).show();
                    btnGetRates.setText("No internet connection!. TRY AGAIN");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rates, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public Loader<Currency> onCreateLoader(int id, Bundle args) {
        return new CurrencyRatesLoader(this, CURRENCY_RATES_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<Currency> loader, Currency currency) {

        // If there is a valid data returned
        // Data will be visible
        if (!currency.getLatestDate().isEmpty() || !currency.getRatesArrayList().toString().isEmpty()) {
            tvLatestDate.setText("Latest update: " + currency.getLatestDate().toString());
            tvRates.setText(currency.getRatesArrayList().toString());
            loading_spinner.setVisibility(View.GONE);
        }

    }

    @Override
    public void onLoaderReset(Loader<Currency> loader) {
        tvLatestDate.setText("");
        tvRates.setText("");
    }


}
