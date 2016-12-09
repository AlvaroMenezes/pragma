package pragma.team.pragmalunch.model.iteractors;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.interfaces.ApiService;
import pragma.team.pragmalunch.interfaces.RestaurantsInteractor;
import pragma.team.pragmalunch.interfaces.RestaurantsPresenter;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.model.service.RestClient;

/**
 * Created by alvaromenezes on 12/9/16.
 */

public class RestaurantsInteractorImpl implements RestaurantsInteractor {

    RestaurantsPresenter presenter;

    public RestaurantsInteractorImpl(RestaurantsPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void syncronize(Context context) {
        new SyncronizeRestaurants(context).execute();
    }


    public ArrayList<Restaurant> getRestaurants() {
        ApiService service = new RestClient();
        ArrayList<Restaurant> restaurants = service.getRestaurants(-33.856159, 151.215256);
        return restaurants;
    }


    private class SyncronizeRestaurants extends AsyncTask<Void, ArrayList<Restaurant>, ArrayList<Restaurant>> {

        private ProgressDialog pd;
        private Context context;

        public SyncronizeRestaurants(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(context, context.getString(R.string.please_wait), context.getString(R.string.load_restaurants), true, false);
        }

        @Override
        protected ArrayList<Restaurant> doInBackground(Void... params) {

            ArrayList<Restaurant> restaurants = getRestaurants();

            return restaurants;
        }

        @Override
        protected void onPostExecute(ArrayList<Restaurant> restaurants) {
            pd.dismiss();
            presenter.loadRestaurants(restaurants);
        }

    }


}
