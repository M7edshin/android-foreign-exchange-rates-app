package shahin.euexchange.background;

import android.content.Context;
import android.util.Log;

import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

import shahin.euexchange.models.Rate;
import shahin.euexchange.networking.FetchRatesData;

public class CurrencyAsyncTaskLoader extends AsyncTaskLoader<List<Rate>> {

    private static final String LOG_TAG = CurrencyAsyncTaskLoader.class.getName();

    private String url;

    public CurrencyAsyncTaskLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "MyLogs: onStartLoading() is called");
        forceLoad();
    }

    @Override
    public List<Rate> loadInBackground() {
        Log.i(LOG_TAG, "MyLogs: loadInBackground() is called");
        if (url == null) return null;
        return FetchRatesData.fetchCurrencyRatesData(url);
    }
}
