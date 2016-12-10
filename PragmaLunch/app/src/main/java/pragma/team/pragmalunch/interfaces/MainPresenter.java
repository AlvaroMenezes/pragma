package pragma.team.pragmalunch.interfaces;

import android.support.v4.app.Fragment;

import pragma.team.pragmalunch.model.data.Restaurant;

/**
 * Created by alvaromenezes on 12/9/16.
 */

public interface MainPresenter {

    void init();

    void onTransaction(Fragment fragment);

    void onDetailRestaurant(Restaurant restaurant);



    void clearOldVote();

    void showMostVotedYesterday();

    void setNotificationScheduler();

    MainView getView();


}
