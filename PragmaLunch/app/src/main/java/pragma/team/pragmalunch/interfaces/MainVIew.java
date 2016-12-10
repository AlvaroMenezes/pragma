package pragma.team.pragmalunch.interfaces;

import android.content.Context;

import pragma.team.pragmalunch.model.data.Restaurant;

/**
 * Created by alvaromenezes on 12/10/16.
 */

public interface MainView {

    void startApp();

    Context getContext();

    void showMostVoted(Restaurant restaurant);

}
