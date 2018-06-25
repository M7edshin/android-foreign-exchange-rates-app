package shahin.euexchange.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import shahin.euexchange.Database.AppDatabase;
import shahin.euexchange.Database.AppExecutors;
import shahin.euexchange.R;
import shahin.euexchange.models.Country;

import static shahin.euexchange.utilities.Constants.INTENT_COUNTRY_KEY;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.tv_name) TextView tv_name;
    @BindView(R.id.tv_alpha2code) TextView tv_alpha2code;
    @BindView(R.id.tv_alpha3code) TextView tv_alpha3code;
    @BindView(R.id.tv_native_name) TextView tv_native_name;
    @BindView(R.id.tv_region) TextView tv_region;
    @BindView(R.id.tv_sub_region) TextView tv_sub_region;
    @BindView(R.id.tv_latitude) TextView tv_latitude;
    @BindView(R.id.tv_longitude) TextView tv_longitude;
    @BindView(R.id.tv_numeric_code) TextView tv_numeric_code;
    @BindView(R.id.tv_native_language) TextView tv_native_language;
    @BindView(R.id.tv_currency_code) TextView tv_currency_code;
    @BindView(R.id.tv_currency_name) TextView tv_currency_name;
    @BindView(R.id.tv_currency_symbol) TextView tv_currency_symbol;
    @BindView(R.id.btn_favorite) Button btn_favorite;

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Intent intentStartedThisActivity = getIntent();

        if(intentStartedThisActivity.hasExtra(INTENT_COUNTRY_KEY)){
            Country country = intentStartedThisActivity.getParcelableExtra(INTENT_COUNTRY_KEY);
            tv_name.setText(country.getName());
            tv_alpha2code.setText(country.getAlpha2Code());
            tv_alpha3code.setText(country.getAlpha3Code());
        }

        database = AppDatabase.getInstance(getApplicationContext());

        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tv_name.getText().toString();

                final Country country = new Country(name,"holder","holder",
                        "holder","holder","holder",
                        "holder","holder",
                        1,"holder",
                        "holder","holder",
                        "holder","holder");

                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        database.countryDao().insertCountry(country);
                        finish();
                    }
                });
            }
        });

    }
}
