package shahin.euexchange;

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

/**
 * Created by M7edShin on 01/08/2017.
 */

public class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getName();

    /**
     * Step 1: Extract data from JSON Format
     * @param currencyRatesJSON
     */
    private static Currency extractCurrencyRatesFromJson(String currencyRatesJSON){
        String latestDate;
        ArrayList<String> ratesArrayList = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(currencyRatesJSON);
            latestDate = baseJsonResponse.getString("date");
            JSONObject ratesObject = baseJsonResponse.getJSONObject("rates");

            for(Iterator<String> iterator = ratesObject.keys(); iterator.hasNext();){
                String key = iterator.next();
                Object value = ratesObject.get(key);
                ratesArrayList.add(key + value);
            }

            return new Currency(latestDate,ratesArrayList);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the currency rate JSON results", e);
        }
        return null;
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

            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }

        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the currency rates JSON Results",e);
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
        } catch (MalformedURLException exception) {
            Log.e(LOG_TAG, "Error with creating URL", exception);
            return null;
        }
        return url;
    }

    public static Currency fetchCurrencyRatesData(String requestUrl){

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

        Currency currency = extractCurrencyRatesFromJson(jsonResponse);
        return currency;
    }
}
