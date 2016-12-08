package pragma.team.pragmalunch.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pragma.team.pragmalunch.model.Response;

import pragma.team.pragmalunch.model.Restaurant;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class RestClient {

    private final String URL_BASE = "https://developers.zomato.com/api/v2.1/";
    private static final String USER_KEY_HEADER = "user-key: 1cb85e5ea29dc54a73019002edd78aeb";

    public interface ServiceInterface {

        @Headers(USER_KEY_HEADER)
        @GET("geocode")
        Call<Response> getResponse(@Query("lat") double latitude, @Query("lon") double longitude);

    }

    private ServiceInterface getServiceInterface() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceInterface api = retrofit.create(ServiceInterface.class);

        return retrofit.create(ServiceInterface.class);
    }

    private Response getResponse(double latitude, double longitude) {

        Response response = null;
        try {
            Call<Response> call = getServiceInterface().getResponse(latitude, longitude);
            response = call.execute().body();

        } catch (Exception e) {
        }

        return response;
    }

    public ArrayList<Restaurant> getRestaurants(double latitude, double longitude) {

        Response response = getResponse(latitude, longitude);

        return response.getRestaurants();

    }

}
