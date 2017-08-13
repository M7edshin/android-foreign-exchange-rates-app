package shahin.euexchange;

/**
 * Created by M7edShin on 30/07/2017.
 */

public class CurrencyRates {

    private int countryResourceId;
    private String currencySymbol;
    private String currencyName;
    private String country;
    private String latestDate;
    private double rate;

    public CurrencyRates(int countryResourceId, String currencySymbol, String currencyName, String country, String latestDate, double rate) {
        this.countryResourceId = countryResourceId;
        this.currencySymbol = currencySymbol;
        this.currencyName = currencyName;
        this.country = country;
        this.latestDate = latestDate;
        this.rate = rate;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setCountryResourceId(int countryResourceId) {
        this.countryResourceId = countryResourceId;
    }

    public int getCountryResourceId() {
        return countryResourceId;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCountry() {
        return country;
    }

    public String getLatestDate() {
        return latestDate;
    }

    public double getRate() {
        return rate;
    }
}
