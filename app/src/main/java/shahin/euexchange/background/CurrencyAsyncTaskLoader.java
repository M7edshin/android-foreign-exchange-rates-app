package shahin.euexchange.background;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

import shahin.euexchange.models.Rates;
import shahin.euexchange.networking.FetchRatesData;

//Created by Mohamed Shahin on 01/08/2017.

public class CurrencyAsyncTaskLoader extends AsyncTaskLoader<List<Rates>> {

    private static final String LOG_TAG = CurrencyAsyncTaskLoader.class.getName();

    private String url;

    public CurrencyAsyncTaskLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "onStartLoading() is called");
        forceLoad();
    }

    @Override
    public List<Rates> loadInBackground() {
        Log.i(LOG_TAG, "loadInBackground() is called");
        if (url == null) return null;
        return FetchRatesData.fetchCurrencyRatesData(url);
    }
}
