package pragma.team.pragmalunch.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.interfaces.MainPresenter;
import pragma.team.pragmalunch.interfaces.OnRestaurantDetailListener;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.presenters.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements OnRestaurantDetailListener {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl(this);
        init();
    }

    private void init() {
        RestaurantsFragment fragment = RestaurantsFragment.newInstance();
        presenter.onTransaction(fragment);
    }

    @Override
    public void showDetail(Restaurant restaurant) {
        presenter.onDetailRestaurant(restaurant);
    }


}
