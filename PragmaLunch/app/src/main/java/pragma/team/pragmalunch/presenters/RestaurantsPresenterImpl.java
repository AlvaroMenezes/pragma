package pragma.team.pragmalunch.presenters;

import android.Manifest;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import pragma.team.pragmalunch.common.Settings;
import pragma.team.pragmalunch.common.Util;
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
    private RestaurantsInteractor interactor;

    private String[] PERMISSIONS = {Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};


    public RestaurantsPresenterImpl(RestaurantsView view) {
        this.view = view;
        interactor = new RestaurantsInteractorImpl(this);
        NetworkControler.getInstance(this).addObserver(this);
    }


    @Override
    public void syncronize() {
        interactor.syncronize();
    }

    @Override
    public void onVote(String restaurantID) {

        if (!hasPermissions()) {

            return;
        }

        if (isTimeOver()) {
            view.hasTimeError();
            return;
        }

        if (interactor.hasVotedToday()) {
            view.hasVotedTodayError();
            return;
        }
        view.updateListWithVote(restaurantID);
        interactor.saveVote(restaurantID);
        interactor.syncronizeVote(restaurantID);

    }


    private boolean isTimeOver() {

        String now = new Util().getCurentHour();
        Integer time = Integer.valueOf(now);

        if (time.intValue() >= Settings.LIMIT_HOUR) {
            return true;
        }
        return false;
    }


    @Override
    public void requestPermission() {
        ActivityCompat.requestPermissions((AppCompatActivity) view.getContext(), PERMISSIONS, 0);

        // ( (AppCompatActivity)view.getContext()).getSupportFragmentManager().beginTransaction().remove( (Fragment) view).commit();
    }


    @Override
    public void loadRestaurants(ArrayList<Restaurant> restaurants) {
        view.loadRestaurants(restaurants);
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }


    @Override
    public void update(Observable observable, Object data) {

        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) data;
        view.loadRestaurants(restaurants);
    }


    @Override
    public boolean hasPermissions() {

        Util util = new Util();
        return util.hasPermissions(view.getContext(), PERMISSIONS);

    }


}
