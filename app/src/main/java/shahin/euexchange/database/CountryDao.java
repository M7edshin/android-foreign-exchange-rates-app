package shahin.euexchange.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import shahin.euexchange.models.Country;

@Dao
public interface CountryDao {
    @Query("SELECT * FROM country")
    LiveData<List<Country>> loadAllCountries();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCountry(Country country);

    @Delete
    void deleteCountry(Country country);

}
