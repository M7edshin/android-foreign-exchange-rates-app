package shahin.euexchange;

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
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RatesActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<CurrencyRates>> {

    private TextView tvLatestDate;
    private ImageView imgEmpty;
    private ProgressBar loading_spinner;
    private ListView lstRates;

    public static final String LOG_TAG = RatesActivity.class.getSimpleName();
    private static final String CURRENCY_RATES_REQUEST_URL = "http://api.fixer.io/latest";
    private static final int RATES_LOADER_ID = 1;

    private String amount = "";

    CurrencyRatesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDialog();
            }
        });

        tvLatestDate = (TextView)findViewById(R.id.tvLatestDate);

        loading_spinner = (ProgressBar)findViewById(R.id.loading_spinner);
        loading_spinner.setVisibility(View.INVISIBLE);

        imgEmpty = (ImageView) findViewById(R.id.imgEmpty);

        lstRates = (ListView) findViewById(R.id.lstRates);
        lstRates.setEmptyView(imgEmpty);

        adapter = new CurrencyRatesAdapter(this, new ArrayList<CurrencyRates>());
        lstRates.setAdapter(adapter);

        getLatestRates();

        lstRates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (amount.isEmpty()) {
                    Toast.makeText(getApplicationContext(), R.string.str_enter_the_amount, Toast.LENGTH_SHORT).show();
                } else {
                    double specifiedAmount = Double.parseDouble(amount);
                    CurrencyRates currencyRates = adapter.getItem(position);
                    double conversion = specifiedAmount * currencyRates.getRate();
                    String result = String.format("%.2f", conversion) + " " + currencyRates.getCurrencyName();
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    @Override
    public Loader<List<CurrencyRates>> onCreateLoader(int id, Bundle args) {
        Log.i(LOG_TAG, "TEST: onCreateLoader() called...");
        return new CurrencyRatesLoader(this, CURRENCY_RATES_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<CurrencyRates>> loader, List<CurrencyRates> listOfTheRates) {
        Log.i(LOG_TAG, "TEST: onLoadFinished() called...");
        loading_spinner.setVisibility(View.GONE);
        adapter.clear();

        if (listOfTheRates != null && !listOfTheRates.isEmpty()) {
            tvLatestDate.setText(getString(R.string.str_latest_date) + "  " + listOfTheRates.get(0).getLatestDate().toString());
            setCountriesInfo(listOfTheRates);
            adapter.addAll(listOfTheRates);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<CurrencyRates>> loader) {
        Log.i(LOG_TAG, "TEST: onLoaderReset() called...");
        adapter.clear();
    }

    private void getLatestRates() {

        imgEmpty.setVisibility(View.INVISIBLE);
        loading_spinner.setVisibility(View.VISIBLE);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(RATES_LOADER_ID, null, RatesActivity.this);

        } else {
            loading_spinner.setVisibility(View.GONE);
            adapter.clear();
            lstRates.setEmptyView(imgEmpty);
            imgEmpty.setVisibility(View.VISIBLE);
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
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                amount = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
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
            case R.id.action_rates_info:
                String url = "https://en.wikipedia.org/wiki/Exchange_rate";
                Uri webPage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;

            case R.id.action_report_suggest:
                sendEmail(getString(R.string.str_suggest_report));
                return true;

            case R.id.action_exit:
                finish();
                System.exit(0);
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

    private void setCountriesInfo(List<CurrencyRates> listOfTheRates) {
        listOfTheRates.get(0).setCountryResourceId(R.mipmap.ic_au);
        listOfTheRates.get(0).setCountry("Australia");
        listOfTheRates.get(0).setCurrencyName("Australian dollar");

        listOfTheRates.get(1).setCountryResourceId(R.mipmap.ic_bg);
        listOfTheRates.get(1).setCountry("Bulgaria");
        listOfTheRates.get(1).setCurrencyName("Bulgarian lev");

        listOfTheRates.get(2).setCountryResourceId(R.mipmap.ic_br);
        listOfTheRates.get(2).setCountry("Brazil");
        listOfTheRates.get(2).setCurrencyName("Brazilian real");

        listOfTheRates.get(3).setCountryResourceId(R.mipmap.ic_ca);
        listOfTheRates.get(3).setCountry("Canada");
        listOfTheRates.get(3).setCurrencyName("Canadian dollar");

        listOfTheRates.get(4).setCountryResourceId(R.mipmap.ic_de);
        listOfTheRates.get(4).setCountry("Switzerland");
        listOfTheRates.get(4).setCurrencyName("Swiss franc");

        listOfTheRates.get(5).setCountryResourceId(R.mipmap.ic_cn);
        listOfTheRates.get(5).setCountry("China");
        listOfTheRates.get(5).setCurrencyName("Chinese yuan renminbi");

        listOfTheRates.get(6).setCountryResourceId(R.mipmap.ic_cz);
        listOfTheRates.get(6).setCountry("Czech");
        listOfTheRates.get(6).setCurrencyName("Czech koruna");

        listOfTheRates.get(7).setCountryResourceId(R.mipmap.ic_dk);
        listOfTheRates.get(7).setCountry("Denmark");
        listOfTheRates.get(7).setCurrencyName("Danish krone");

        listOfTheRates.get(8).setCountryResourceId(R.mipmap.ic_uk);
        listOfTheRates.get(8).setCountry("United Kingdom");
        listOfTheRates.get(8).setCurrencyName("Pound sterling");

        listOfTheRates.get(9).setCountryResourceId(R.mipmap.ic_hk);
        listOfTheRates.get(9).setCountry("Special Administrative Region");
        listOfTheRates.get(9).setCurrencyName("Hong Kong dollar");

        listOfTheRates.get(10).setCountryResourceId(R.mipmap.ic_hr);
        listOfTheRates.get(10).setCountry("Croatia");
        listOfTheRates.get(10).setCurrencyName("Croatian kuna");

        listOfTheRates.get(11).setCountryResourceId(R.mipmap.ic_hu);
        listOfTheRates.get(11).setCountry("Hungary");
        listOfTheRates.get(11).setCurrencyName("Hungarian forint");

        listOfTheRates.get(12).setCountryResourceId(R.mipmap.ic_id);
        listOfTheRates.get(12).setCountry("Indonesia");
        listOfTheRates.get(12).setCurrencyName("Indonesian rupiah");

        listOfTheRates.get(13).setCountryResourceId(R.mipmap.ic_il);
        listOfTheRates.get(13).setCountry("Israel");
        listOfTheRates.get(13).setCurrencyName("Israeli shekel");

        listOfTheRates.get(14).setCountryResourceId(R.mipmap.ic_in);
        listOfTheRates.get(14).setCountry("India");
        listOfTheRates.get(14).setCurrencyName("Indian rupee");

        listOfTheRates.get(15).setCountryResourceId(R.mipmap.ic_jp);
        listOfTheRates.get(15).setCountry("Japan");
        listOfTheRates.get(15).setCurrencyName("Japanese yen");

        listOfTheRates.get(16).setCountryResourceId(R.mipmap.ic_kr);
        listOfTheRates.get(16).setCountry("South Korean");
        listOfTheRates.get(16).setCurrencyName("South Korean won");

        listOfTheRates.get(17).setCountryResourceId(R.mipmap.ic_mx);
        listOfTheRates.get(17).setCountry("Mexico");
        listOfTheRates.get(17).setCurrencyName("Mexican peso");

        listOfTheRates.get(18).setCountryResourceId(R.mipmap.ic_my);
        listOfTheRates.get(18).setCountry("Malaysia");
        listOfTheRates.get(18).setCurrencyName("Malaysian ringgit");

        listOfTheRates.get(19).setCountryResourceId(R.mipmap.ic_no);
        listOfTheRates.get(19).setCountry("Norway");
        listOfTheRates.get(19).setCurrencyName("Norwegian krone");

        listOfTheRates.get(20).setCountryResourceId(R.mipmap.ic_nz);
        listOfTheRates.get(20).setCountry("New Zealand");
        listOfTheRates.get(20).setCurrencyName("New Zealand dollar");

        listOfTheRates.get(21).setCountryResourceId(R.mipmap.ic_ph);
        listOfTheRates.get(21).setCountry("Philippines");
        listOfTheRates.get(21).setCurrencyName("Philippine peso");

        listOfTheRates.get(22).setCountryResourceId(R.mipmap.ic_pl);
        listOfTheRates.get(22).setCountry("Poland");
        listOfTheRates.get(22).setCurrencyName("Polish zloty");

        listOfTheRates.get(23).setCountryResourceId(R.mipmap.ic_ro);
        listOfTheRates.get(23).setCountry("Romania");
        listOfTheRates.get(23).setCurrencyName("Romanian leu");

        listOfTheRates.get(24).setCountryResourceId(R.mipmap.ic_ru);
        listOfTheRates.get(24).setCountry("Russia");
        listOfTheRates.get(24).setCurrencyName("Russian rouble");

        listOfTheRates.get(25).setCountryResourceId(R.mipmap.ic_se);
        listOfTheRates.get(25).setCountry("Sweden");
        listOfTheRates.get(25).setCurrencyName("Swedish krona");

        listOfTheRates.get(26).setCountryResourceId(R.mipmap.ic_sg);
        listOfTheRates.get(26).setCountry("Singapore");
        listOfTheRates.get(26).setCurrencyName("Singapore dollar");

        listOfTheRates.get(27).setCountryResourceId(R.mipmap.ic_th);
        listOfTheRates.get(27).setCountry("Thailand");
        listOfTheRates.get(27).setCurrencyName("Thai baht");

        listOfTheRates.get(28).setCountryResourceId(R.mipmap.ic_tr);
        listOfTheRates.get(28).setCountry("Turkey");
        listOfTheRates.get(28).setCurrencyName("Turkish lira");

        listOfTheRates.get(29).setCountryResourceId(R.mipmap.ic_us);
        listOfTheRates.get(29).setCountry("United States");
        listOfTheRates.get(29).setCurrencyName("US dollar");

        listOfTheRates.get(30).setCountryResourceId(R.mipmap.ic_za);
        listOfTheRates.get(30).setCountry("South Africa");
        listOfTheRates.get(30).setCurrencyName("South African rand");
    }



}
