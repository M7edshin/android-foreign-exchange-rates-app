package shahin.euexchange.activities;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.location.GnssNavigationMessage;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import shahin.euexchange.database.AppDatabase;
import shahin.euexchange.database.AppExecutors;
import shahin.euexchange.R;
import shahin.euexchange.viewmodels.FavoriteViewModel;
import shahin.euexchange.models.Country;
import shahin.euexchange.ui.FavoriteRecyclerAdapter;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;
import static shahin.euexchange.utilities.Constants.AD_ID;
import static shahin.euexchange.utilities.Constants.INTENT_COUNTRY_KEY;

public class FavoriteActivity extends AppCompatActivity implements FavoriteRecyclerAdapter.FavoriteAdapterListener {

    @BindView(R.id.rv_favorite) RecyclerView rv_favorite;
    @BindView(R.id.adView) AdView adView;

    private final String TAG = FavoriteActivity.class.getSimpleName();
    private FavoriteRecyclerAdapter favoriteRecyclerAdapter;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        ButterKnife.bind(this);

        MobileAds.initialize(this, AD_ID);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        rv_favorite.setVisibility(View.VISIBLE);

        rv_favorite.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        rv_favorite.addItemDecoration(decoration);
        favoriteRecyclerAdapter = new FavoriteRecyclerAdapter(this, this);
        rv_favorite.setAdapter(favoriteRecyclerAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            // Called when a user swipes left or right on a ViewHolder
            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        int position = viewHolder.getAdapterPosition();
                        List<Country> countryList = favoriteRecyclerAdapter.getCountryList();
                        database.countryDao().deleteCountry(countryList.get(position));
                    }
                });

            }
        }).attachToRecyclerView(rv_favorite);

        database = AppDatabase.getInstance(getApplicationContext());

        retrieveCountries();
    }



    private void retrieveCountries(){
        FavoriteViewModel viewModel = ViewModelProviders.of(this).get(FavoriteViewModel.class);
        viewModel.getCountries().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(@Nullable List<Country> countries) {
                Log.d(TAG, "Updating list of the countries from LiveData in ViewModel");
                favoriteRecyclerAdapter.setCountries(countries);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }

}
