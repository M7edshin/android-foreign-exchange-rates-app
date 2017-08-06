package shahin.euexchange;

import java.util.ArrayList;

/**
 * Created by M7edShin on 30/07/2017.
 */

public class Currency {

    private String latestDate;
    private ArrayList<String> ratesArrayList;

    public Currency(String latestDate, ArrayList<String> ratesArrayList){
        this.latestDate = latestDate;
        this.ratesArrayList = ratesArrayList;
    }

    public String getLatestDate() {
        return latestDate;
    }

    public ArrayList<String> getRatesArrayList() {
        return ratesArrayList;
    }
}
