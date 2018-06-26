package shahin.euexchange.ViewModels;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import shahin.euexchange.Database.AppDatabase;
import shahin.euexchange.models.Country;

public class FavoriteViewModel extends AndroidViewModel {

    private static final String TAG = FavoriteViewModel.class.getSimpleName();

    private LiveData<List<Country>> countries;

    public FavoriteViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the clients from the database");
        countries = database.countryDao().loadAllCountries();
    }

    public LiveData<List<Country>> getCountries() {
        return countries;
    }
}