package shahin.euexchange.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import shahin.euexchange.database.AppDatabase;
import shahin.euexchange.database.AppExecutors;
import shahin.euexchange.R;
import shahin.euexchange.models.Country;
import shahin.euexchange.widget.MyWidgetProvider;
import shahin.euexchange.widget.WidgetObject;

import static shahin.euexchange.utilities.Constants.AD_ID;
import static shahin.euexchange.utilities.Constants.INTENT_COUNTRY_KEY;
import static shahin.euexchange.utilities.Constants.WIDGET_SHARED_PREFS_KEY;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.iv_flag)
    ImageView iv_flag;
    @BindView(R.id.tv_alpha2code)
    TextView tv_alpha2code;
    @BindView(R.id.tv_alpha3code)
    TextView tv_alpha3code;
    @BindView(R.id.tv_native_name)
    TextView tv_native_name;
    @BindView(R.id.tv_region)
    TextView tv_region;
    @BindView(R.id.tv_sub_region)
    TextView tv_sub_region;
    @BindView(R.id.tv_numeric_code)
    TextView tv_numeric_code;
    @BindView(R.id.tv_native_language)
    TextView tv_native_language;
    @BindView(R.id.tv_currency_code)
    TextView tv_currency_code;
    @BindView(R.id.tv_currency_name)
    TextView tv_currency_name;
    @BindView(R.id.tv_currency_symbol)
    TextView tv_currency_symbol;
    @BindView(R.id.adView)
    AdView adView;


    private AppDatabase database;

    private String name;
    private String alpha2code;
    private String alpha3code;
    private String nativeName;
    private String region;
    private String subRegion;
    private String latitude;
    private String longitude;
    private int numericCode;
    private String nativeLanguage;
    private String currencyCode;
    private String currencyName;
    private String currencySymbol;
    private String flagPNG;

    private Country country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        MobileAds.initialize(this, AD_ID);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        Intent intentStartedThisActivity = getIntent();

        if (intentStartedThisActivity.hasExtra(INTENT_COUNTRY_KEY)) {
            country = intentStartedThisActivity.getParcelableExtra(INTENT_COUNTRY_KEY);

            name = country.getName();
            alpha2code = country.getAlpha2Code();
            alpha3code = country.getAlpha3Code();
            nativeName = country.getNativeName();
            region = country.getRegion();
            subRegion = country.getSubRegion();
            latitude = country.getLatitude();
            longitude = country.getLongitude();
            numericCode = country.getNumericCode();
            nativeLanguage = country.getNativeLanguage();
            currencyCode = country.getCurrencyCode();
            currencyName = country.getCurrencyName();
            currencySymbol = country.getCurrencySymbol();
            flagPNG = country.getFlagPng();

            tv_alpha2code.setText(String.format("%s%s", getString(R.string.alpha_2_code), alpha2code));
            tv_alpha3code.setText(String.format("%s%s", getString(R.string.alpha_3_code), alpha3code));
            tv_native_name.setText(nativeName);
            tv_region.setText(String.format("%s%s", getString(R.string.region), region));
            tv_sub_region.setText(subRegion);
            tv_numeric_code.setText(String.format("%s%s", getString(R.string.country_code), String.valueOf(numericCode)));
            tv_native_language.setText(String.format("%s%s", getString(R.string.lang), nativeLanguage));
            tv_currency_code.setText(String.format("%s%s", getString(R.string.code), currencyCode));
            tv_currency_name.setText(currencyName);
            tv_currency_symbol.setText(String.format("%s%s", getString(R.string.symbol), currencySymbol));

            Picasso.get()
                    .load(country.getFlagPng())
                    .placeholder(R.drawable.ic_not_applicable)
                    .error(R.drawable.ic_not_applicable)
                    .into(iv_flag);

            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            intent.putExtra("Latitude", latitude);
            intent.putExtra("Longitude", longitude);
            intent.putExtra("Country", name);
        }

        database = AppDatabase.getInstance(getApplicationContext());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(name);

    }

    private void makeData() {
        ArrayList<WidgetObject> widgetObjects = new ArrayList<>();
        widgetObjects.add(new WidgetObject(getString(R.string.country) + name));
        widgetObjects.add(new WidgetObject(getString(R.string.currency) + currencyName));
        widgetObjects.add(new WidgetObject(getString(R.string.symbol) + currencySymbol));
        Gson gson = new Gson();
        String json = gson.toJson(widgetObjects);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(WIDGET_SHARED_PREFS_KEY, json).apply();
    }

    private void sendBroadcast() {

        Intent intent = new Intent(this, MyWidgetProvider.class);
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE\"");
        sendBroadcast(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_favorite_it:

                final Country country = new Country(name, alpha2code, alpha3code,
                        nativeName, region, subRegion,
                        latitude, longitude,
                        numericCode, nativeLanguage,
                        currencyCode, currencyName,
                        currencySymbol, flagPNG);

                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        database.countryDao().insertCountry(country);
                        finish();
                    }
                });
                snackBarShort(getString(R.string.added_to_favorite));

                return true;

            case R.id.action_widget_it:
                makeData();
                sendBroadcast();
                Toast.makeText(getApplicationContext(), R.string.widget_it, Toast.LENGTH_SHORT).show();
                snackBarShort(getString(R.string.widget_it));
                return true;

            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void snackBarShort(String message){
        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

}

