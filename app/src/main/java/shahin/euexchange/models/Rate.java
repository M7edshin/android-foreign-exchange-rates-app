package shahin.euexchange.models;


import android.os.Parcel;
import android.os.Parcelable;

public class Rate implements Parcelable {

    public static final Parcelable.Creator<Rate> CREATOR = new Parcelable.Creator<Rate>() {
        @Override
        public Rate createFromParcel(Parcel parcel) {
            return new Rate(parcel);
        }

        @Override
        public Rate[] newArray(int i) {
            return new Rate[i];
        }
    };
    private int imageId;
    private String symbol;
    private String currency;
    private String country;
    private String latestDate;
    private String rate;

    public Rate(int imageId, String symbol, String currency, String country, String latestDate, String rate) {
        this.imageId = imageId;
        this.symbol = symbol;
        this.currency = currency;
        this.country = country;
        this.latestDate = latestDate;
        this.rate = rate;
    }

    private Rate(Parcel in) {
        this.imageId = in.readInt();
        this.currency = in.readString();
        this.currency = in.readString();
        this.country = in.readString();
        this.latestDate = in.readString();
        this.rate = in.readString();
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int countryResourceId) {
        this.imageId = countryResourceId;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatestDate() {
        return latestDate;
    }

    public String getRate() {
        return rate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageId);
        parcel.writeString(symbol);
        parcel.writeString(currency);
        parcel.writeString(country);
        parcel.writeString(latestDate);
        parcel.writeString(rate);
    }
}
