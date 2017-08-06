package shahin.euexchange;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

/**
 * Created by M7edShin on 01/08/2017.
 */

public class CurrencyRatesLoader extends AsyncTaskLoader<Currency> {

    /** Tag for log messages */
    private static final String LOG_TAG = CurrencyRatesLoader.class.getName();
    private String url;

    public CurrencyRatesLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "TEST: onStartLoading() called...");
        forceLoad();
    }

    // Background thread to do the task of getting the data from internet
    @Override
    public Currency loadInBackground() {
        Log.i(LOG_TAG, "TEST: loadInBackground() called...");
        if(url == null)return null;
        // Perform the network request, JSON Parse, and extract News data
        return QueryUtils.fetchCurrencyRatesData(url);
    }

}
