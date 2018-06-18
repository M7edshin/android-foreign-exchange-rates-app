package shahin.euexchange.networking;


import retrofit2.Call;
import retrofit2.http.GET;
import shahin.euexchange.models.CountryResponse;

public interface ApiRetrofitInterface{
    @GET("/v1/Country/getCountries/")
    Call<CountryResponse> getCountryResponse();
}
