package pragma.team.pragmalunch.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class Response {

    private Nearby_restaurants[] nearby_restaurants;

    public List<Restaurant> getRestaurants() {

        List<Restaurant> restaurants = new ArrayList<>();
        for (Nearby_restaurants r : nearby_restaurants) {
            restaurants.add(r.restaurant);
        }
        return restaurants;
    }

}

