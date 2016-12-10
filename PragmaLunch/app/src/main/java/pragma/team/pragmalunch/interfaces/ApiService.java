package pragma.team.pragmalunch.interfaces;

import java.util.ArrayList;

import pragma.team.pragmalunch.model.data.Restaurant;

/**
 * Created by alvaromenezes on 12/9/16.
 */

public interface ApiService {

    ArrayList<Restaurant> getRestaurants(double latitude, double longitude);

    void onVote(String restaurantID, String IMEI);
}
