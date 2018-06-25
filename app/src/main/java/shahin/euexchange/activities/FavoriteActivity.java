package shahin.euexchange.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import shahin.euexchange.Database.AppDatabase;
import shahin.euexchange.Database.AppExecutors;
import shahin.euexchange.R;
import shahin.euexchange.ViewModels.FavoriteViewModel;
import shahin.euexchange.models.Country;
import shahin.euexchange.ui.FavoriteRecyclerAdapter;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class FavoriteActivity extends AppCompatActivity implements FavoriteRecyclerAdapter.ItemClickListener {

    @BindView(R.id.rv_favorite) RecyclerView rv_favorite;

    private final String TAG = FavoriteActivity.class.getSimpleName();
    private FavoriteRecyclerAdapter favoriteRecyclerAdapter;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        ButterKnife.bind(this);

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
                        database.countryDao().deletCountry(countryList.get(position));
                    }
                });

            }
        }).attachToRecyclerView(rv_favorite);

        database = AppDatabase.getInstance(getApplicationContext());

        retrieveCountries();
    }

    @Override
    public void onItemClickListener(int itemId) {
        Intent intent = new Intent(this, FavCountryActivity.class);
        intent.putExtra(FavCountryActivity.EXTRA_COUNTRY_ID, itemId);
        startActivity(intent);
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
}
