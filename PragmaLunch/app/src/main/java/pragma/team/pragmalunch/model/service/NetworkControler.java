package pragma.team.pragmalunch.model.service;

import android.content.Context;
import android.os.SystemClock;

import java.util.Observable;

import pragma.team.pragmalunch.common.Settings;
import pragma.team.pragmalunch.interfaces.RestaurantsPresenter;
import pragma.team.pragmalunch.model.iteractors.RestaurantsInteractorImpl;

/**
 * Created by alvaromenezes on 12/9/16.
 */

public class NetworkControler extends Observable implements Runnable {

    private static NetworkControler INSTANCE;
    RestaurantsPresenter presenter;



    public NetworkControler(RestaurantsPresenter presenter) {
        this.presenter = presenter;
    }

    public static NetworkControler getInstance(RestaurantsPresenter presenter) {
        if (INSTANCE == null)
            INSTANCE = new NetworkControler(presenter);
        return INSTANCE;
    }


    @Override
    public void run() {

        while (true) {
            SystemClock.sleep(Settings.CONNECTION_INTERVAL);
            RestaurantsInteractorImpl interactor = new RestaurantsInteractorImpl(presenter);
            setChanged();
            notifyObservers(interactor.getRestaurants());

        }
    }


}
