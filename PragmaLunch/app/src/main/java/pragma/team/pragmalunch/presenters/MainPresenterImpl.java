package pragma.team.pragmalunch.presenters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.interfaces.MainPresenter;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.model.service.NetworkControler;
import pragma.team.pragmalunch.view.RestaurantDetailFragment;

/**
 * Created by alvaromenezes on 12/9/16.
 */

public class MainPresenterImpl implements MainPresenter {

    private FragmentActivity activity;

    public MainPresenterImpl(FragmentActivity activity) {
        this.activity = activity;
        startNetwork();
    }

    @Override
    public void onTransaction(Fragment fragment) {
        final String TAG = fragment.getClass().getName();
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main_container, fragment, TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onDetailRestaurant(Restaurant restaurant) {
        RestaurantDetailFragment fragment = RestaurantDetailFragment.newInstance(restaurant);
        onTransaction(fragment);
    }

    @Override
    public void startNetwork() {
        new Thread(NetworkControler.getInstance()).start();
    }
}
