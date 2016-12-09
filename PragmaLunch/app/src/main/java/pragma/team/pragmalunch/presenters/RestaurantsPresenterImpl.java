package pragma.team.pragmalunch.presenters;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import pragma.team.pragmalunch.interfaces.RestaurantsInteractor;
import pragma.team.pragmalunch.interfaces.RestaurantsPresenter;
import pragma.team.pragmalunch.interfaces.RestaurantsView;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.model.iteractors.RestaurantsInteractorImpl;
import pragma.team.pragmalunch.model.service.NetworkControler;

/**
 * Created by alvaromenezes on 12/9/16.
 */

public class RestaurantsPresenterImpl implements RestaurantsPresenter, Observer {

    private RestaurantsView view;
    private RestaurantsInteractor iteractor;

    public RestaurantsPresenterImpl(RestaurantsView view) {
        this.view = view;
        iteractor = new RestaurantsInteractorImpl(this);
        NetworkControler.getInstance().addObserver(this);

    }


    @Override
    public void syncronize() {
        iteractor.syncronize(view.getContext());
    }


    @Override
    public void loadRestaurants(ArrayList<Restaurant> restaurants) {
        view.loadRestaurants(restaurants);
    }


    @Override
    public void update(Observable observable, Object data) {

        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) data;
        view.loadRestaurants(restaurants);
    }
}
