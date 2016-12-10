package pragma.team.pragmalunch.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.common.PreferencesHelper;
import pragma.team.pragmalunch.common.Settings;
import pragma.team.pragmalunch.interfaces.MainPresenter;
import pragma.team.pragmalunch.interfaces.MainView;
import pragma.team.pragmalunch.interfaces.OnRestaurantDetailListener;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.presenters.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainView, OnRestaurantDetailListener {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenterImpl(this);
        presenter.init();
        presenter.setNotificationScheduler();

    }

    private void loadFragment() {
        RestaurantsFragment fragment = RestaurantsFragment.newInstance();
        presenter.onTransaction(fragment);
    }

    @Override
    public void showDetail(Restaurant restaurant) {
        presenter.onDetailRestaurant(restaurant);
    }

    @Override
    public void startApp() {
        presenter.clearOldVote();
        loadFragment();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMostVoted(Restaurant restaurant) {
        showDetail(restaurant);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        final String TAG = RestaurantsFragment.class.getName();

        RestaurantsFragment fragment = (RestaurantsFragment) getSupportFragmentManager().findFragmentByTag(TAG);

        if (fragment != null) {

            fragment.init();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.most_voted_yesterday:
                presenter.showMostVotedYesterday();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
