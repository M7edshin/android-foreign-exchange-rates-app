package shahin.euexchange;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by M7edShin on 01/08/2017.
 */

public class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getName();
    private static final String JSON_KEY_DATE = "date";
    private static final String JSON_KEY_RATES = "rates";


    private QueryUtils() {
    }

    /**
     * Step 1: Extract data from JSON Format
     *
     * @param currencyRatesJSON
     */
    private static List<CurrencyRates> extractCurrencyRatesFromJson(String currencyRatesJSON) {

        if (TextUtils.isEmpty(currencyRatesJSON))
            return null;// If the JSON string is empty or null, then return early.

        String latestDate;
        List<CurrencyRates> ratesList = new ArrayList<>(); //ArrayList from List Object


        try {
            JSONObject baseJsonResponse = new JSONObject(currencyRatesJSON);
            latestDate = baseJsonResponse.getString(JSON_KEY_DATE);
            JSONObject ratesObject = baseJsonResponse.getJSONObject(JSON_KEY_RATES);
            for(Iterator<String> iterator = ratesObject.keys(); iterator.hasNext();){
                String currencySymbol = iterator.next();
                double rate = (double) ratesObject.get(currencySymbol);

                CurrencyRates currencyRates = new CurrencyRates(R.mipmap.ic_launcher_round, currencySymbol, "currencyName",
                        "countryName", latestDate, rate);
                ratesList.add(currencyRates);
            }

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the currency rates in JSON", e);
        }
        return ratesList;
    }

    /**
     * Step 2
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }

        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the currency rates JSON Results", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // function must handle java.io.IOException here
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Step 3
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }


    /**
     * Step 4
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL", e);
            return null;
        }
        return url;
    }

    public static List<CurrencyRates> fetchCurrencyRatesData(String requestUrl) {

        Log.i(LOG_TAG, "TEST: fetchCurrencyRatesData() called...");

        /**
         * To force the background thread to sleep for 2 seconds, we are temporarily simulating
         * a very slow network response time.
         * We are “pretending” that it took a long time to fetch the response.
         * That allows us to see the loading spinner on the screen for a little longer than it normally would appear for.
         */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = "";
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error with perform HTTP request to the URL", e);
        }

        return extractCurrencyRatesFromJson(jsonResponse);
    }
}
