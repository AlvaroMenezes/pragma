package pragma.team.pragmalunch.interfaces;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;

import pragma.team.pragmalunch.model.data.Restaurant;

/**
 * Created by alvaromenezes on 12/8/16.
 */

public interface RestaurantsView {

    void setupList(View view);

    void hasVotedTodayError();

    void updateListWithVote(String restaurantID);

    void loadRestaurants(ArrayList<Restaurant> restaurants);

    View getView();

    Context getContext();

    void hasTimeError();
}
