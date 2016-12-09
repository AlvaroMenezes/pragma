package pragma.team.pragmalunch.model.service;

import android.os.SystemClock;

import java.util.Observable;

import pragma.team.pragmalunch.common.Settings;
import pragma.team.pragmalunch.model.iteractors.RestaurantsInteractorImpl;

/**
 * Created by alvaromenezes on 12/9/16.
 */

public class NetworkControler extends Observable implements Runnable {

    private static NetworkControler INSTANCE;

    public static NetworkControler getInstance() {
        if (INSTANCE == null)
            INSTANCE = new NetworkControler();
        return INSTANCE;
    }


    @Override
    public void run() {

        while (true) {
            SystemClock.sleep(Settings.CONNECTION_INTERVAL);
            RestaurantsInteractorImpl interactor = new RestaurantsInteractorImpl(null);
            setChanged();
            notifyObservers(interactor.getRestaurants());

        }
    }


}
