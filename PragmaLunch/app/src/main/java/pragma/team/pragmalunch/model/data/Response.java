package pragma.team.pragmalunch.model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class Response implements Serializable {

    private Nearby_restaurants[] nearby_restaurants;

    public ArrayList<Restaurant> getRestaurants() {

        ArrayList<Restaurant> restaurants = new ArrayList<>();
        for (Nearby_restaurants r : nearby_restaurants) {
            r.restaurant.setVotes(getFakeVote());
            restaurants.add(r.restaurant);
        }

        Collections.sort(restaurants, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant lhs, Restaurant rhs) {
                Integer a = lhs.getVotes();
                Integer b = rhs.getVotes();
                return b.compareTo(a);
            }
        });

        return restaurants;
    }


    private int getFakeVote() {

        int min = 0;
        int max = 15;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


}

