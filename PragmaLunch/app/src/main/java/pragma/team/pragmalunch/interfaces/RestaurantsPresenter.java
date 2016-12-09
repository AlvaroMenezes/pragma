package pragma.team.pragmalunch.interfaces;

import java.util.ArrayList;

import pragma.team.pragmalunch.model.data.Restaurant;

/**
 * Created by alvaromenezes on 12/8/16.
 */

public interface RestaurantsPresenter {

    void syncronize();


    void loadRestaurants(ArrayList<Restaurant> restaurants);

}
