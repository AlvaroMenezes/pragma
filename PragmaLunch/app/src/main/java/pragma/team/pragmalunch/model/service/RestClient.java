package pragma.team.pragmalunch.model.service;

import java.util.ArrayList;

import pragma.team.pragmalunch.common.Settings;
import pragma.team.pragmalunch.interfaces.ApiService;
import pragma.team.pragmalunch.model.data.Response;
import pragma.team.pragmalunch.model.data.Restaurant;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class RestClient implements ApiService {


    public interface ServiceInterface {

        @Headers(Settings.ZOMATO_USER_KEY_HEADER)
        @GET("geocode")
        Call<Response> getResponse(@Query("lat") double latitude, @Query("lon") double longitude);

    }

    private ServiceInterface getServiceInterface() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Settings.URL_BASE)
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
