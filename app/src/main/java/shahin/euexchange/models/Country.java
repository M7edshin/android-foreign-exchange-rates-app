package shahin.euexchange.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable{

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("Alpha3Code")
    @Expose
    private String alpha3Code;
    @SerializedName("NativeName")
    @Expose
    private String nativeName;
    @SerializedName("Region")
    @Expose
    private String region;
    @SerializedName("SubRegion")
    @Expose
    private String subRegion;
    @SerializedName("Latitude")
    @Expose
    private String latitude;
    @SerializedName("Longitude")
    @Expose
    private String longitude;
    @SerializedName("Area")
    @Expose
    private Object area;
    @SerializedName("NumericCode")
    @Expose
    private Integer numericCode;
    @SerializedName("NativeLanguage")
    @Expose
    private String nativeLanguage;
    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("CurrencyName")
    @Expose
    private String currencyName;
    @SerializedName("CurrencySymbol")
    @Expose
    private String currencySymbol;
    @SerializedName("Flag")
    @Expose
    private String flag;
    @SerializedName("FlagPng")
    @Expose
    private String flagPng;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public Integer getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(Integer numericCode) {
        this.numericCode = numericCode;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlagPng() {
        return flagPng;
    }

    public void setFlagPng(String flagPng) {
        this.flagPng = flagPng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(alpha2Code);
        parcel.writeString(alpha3Code);
        parcel.writeString(nativeName);
        parcel.writeString(region);
        parcel.writeString(subRegion);
        parcel.writeString(latitude);
        parcel.writeString(longitude);
        //parcel.writeString(String.valueOf(area));
        parcel.writeInt(numericCode);
        parcel.writeString(nativeLanguage);
        parcel.writeString(currencyCode);
        parcel.writeString(currencyName);
        parcel.writeString(currencySymbol);
        parcel.writeString(flagPng);
    }

    private Country(Parcel in){
        this.name = in.readString();
        this.alpha2Code = in.readString();
        this.alpha3Code = in.readString();
        this.nativeName = in.readString();
        this.region = in.readString();
        this.subRegion = in.readString();
        this.latitude = in.readString();
        this.longitude = in.readString();
        //this.area = in.readString();
        this.numericCode = in.readInt();
        this.nativeLanguage = in.readString();
        this.currencyCode = in.readString();
        this.currencyName = in.readString();
        this.currencySymbol = in.readString();
        this.flagPng = in.readString();
    }

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>(){

        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}
