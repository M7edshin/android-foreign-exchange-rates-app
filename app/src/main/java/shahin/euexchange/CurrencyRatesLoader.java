package shahin.euexchange;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;


//Created by Mohamed Shahin on 01/08/2017.


public class CurrencyRatesLoader extends AsyncTaskLoader<List<CurrencyRates>> {

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

    @Override
    public List<CurrencyRates> loadInBackground() {
        Log.i(LOG_TAG, "TEST: loadInBackground() called...");
        if (url == null) return null;
        return QueryUtils.fetchCurrencyRatesData(url);
    }

}
