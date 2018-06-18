package shahin.euexchange.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shahin.euexchange.R;
import shahin.euexchange.models.Country;
import shahin.euexchange.models.CountryResponse;
import shahin.euexchange.networking.ApiRetrofitInterface;
import shahin.euexchange.networking.RetrofitApiClient;
import shahin.euexchange.ui.CountryRecyclerAdapter;

import static shahin.euexchange.utilities.Constants.INTENT_COUNTRY_KEY;

public class CountryActivity extends AppCompatActivity implements CountryRecyclerAdapter.CurrencyAdapterListener{

    public static final String LOG_TAG = CountryActivity.class.getSimpleName();

    @BindView(R.id.rv_countries) RecyclerView rv_countries;
    @BindView(R.id.iv_empty) ImageView iv_empty;
    @BindView(R.id.pb_loading) ProgressBar pb_loading;
    @BindView(R.id.adView) AdView adView;
    @BindView(R.id.et_search) EditText et_search;

    private CountryRecyclerAdapter countryRecyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        rv_countries.setLayoutManager(linearLayoutManager);

        loadCountries();

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                countryRecyclerAdapter.getFilter().filter(editable);
            }
        });
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
                    countryRecyclerAdapter = new CountryRecyclerAdapter(CountryActivity.this, response.body().getCountryList(),CountryActivity.this);
                    rv_countries.setAdapter(countryRecyclerAdapter);
                    pb_loading.setVisibility(View.GONE);
                    iv_empty.setVisibility(View.GONE);
                }else{
                    int statusCode = response.code();
                    Toast.makeText(getApplicationContext(), "Failed " + String.valueOf(statusCode), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCurrencySelected(Country country) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(INTENT_COUNTRY_KEY, country);
        startActivity(intent);
    }

    @Override
    public void onCurrencyLongClickListener(Country country) {

    }
}
