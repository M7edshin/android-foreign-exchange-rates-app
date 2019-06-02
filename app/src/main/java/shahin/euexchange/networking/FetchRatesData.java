package shahin.euexchange.networking;

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

import shahin.euexchange.R;
import shahin.euexchange.models.Rate;

public class FetchRatesData {

    private static final String LOG_TAG = FetchRatesData.class.getName();

    private static final String JSON_KEY_DATE = "date";
    private static final String JSON_KEY_RATES = "rates";


    private FetchRatesData() {
    }

    /**
     * Step 1: Extract data from JSON Format
     */
    private static List<Rate> extractCurrencyRatesFromJson(String json) {

        if (TextUtils.isEmpty(json))
            return null;

        String latestDate;
        List<Rate> rateList = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(json);
            latestDate = baseJsonResponse.getString(JSON_KEY_DATE);
            JSONObject ratesObject = baseJsonResponse.getJSONObject(JSON_KEY_RATES);
            for (Iterator<String> iterator = ratesObject.keys(); iterator.hasNext(); ) {
                String currencySymbol = iterator.next();
                String rate = String.valueOf(ratesObject.get(currencySymbol));

                Rate currencyRate = new Rate(R.mipmap.ic_launcher_round, currencySymbol, "Currency Name",
                        "Country Name", latestDate, rate);
                rateList.add(currencyRate);
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem occurred during parsing the rates", e);
        }
        return rateList;
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
            Log.e(LOG_TAG, "Problem occurred during making a HTTP request", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
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
        URL url;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem occurred during creating URL", e);
            return null;
        }
        return url;
    }

    public static List<Rate> fetchCurrencyRatesData(String requestUrl) {

        Log.i(LOG_TAG, "fetchCurrencyRatesData() is called");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        URL url = createUrl(requestUrl);

        String jsonResponse = "";
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem occurred during performing HTTP request", e);
        }
        return extractCurrencyRatesFromJson(jsonResponse);
    }
}
