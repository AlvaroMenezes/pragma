package pragma.team.pragmalunch.interfaces;

import android.content.Context;

import java.util.ArrayList;

import pragma.team.pragmalunch.model.data.Restaurant;

/**
 * Created by alvaromenezes on 12/8/16.
 */

public interface RestaurantsPresenter {
    void syncronize();

    boolean hasPermissions();

    void onVote(String restaurantID);

    void loadRestaurants(ArrayList<Restaurant> restaurants);

    Context getContext();

    void requestPermission();
}
