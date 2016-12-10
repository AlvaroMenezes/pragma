package pragma.team.pragmalunch.model.iteractors;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;

import java.util.ArrayList;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.common.LocationHelper;
import pragma.team.pragmalunch.common.PreferencesHelper;
import pragma.team.pragmalunch.common.Settings;
import pragma.team.pragmalunch.common.Util;
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
    public void syncronize() {
        new SyncronizeRestaurants(presenter.getContext()).execute();
    }

    @Override
    public void saveVote(String restaurantID) {

        String today = new Util().getCurentDate();
        PreferencesHelper pref = new PreferencesHelper(presenter.getContext());
        pref.saveKey(Settings.KEY_VOTE_DAY, today);
        pref.saveKey(Settings.KEY_RESTAURANT_ID, restaurantID);

    }

    @Override
    public boolean hasVotedToday() {

        String today = new Util().getCurentDate();
        PreferencesHelper pref = new PreferencesHelper(presenter.getContext());
        String lastVotedDay = pref.getValue(Settings.KEY_VOTE_DAY);
        return today.equalsIgnoreCase(lastVotedDay);
    }

    @Override
    public String getVoteID() {
        PreferencesHelper pref = new PreferencesHelper(presenter.getContext());
        String voteID = pref.getValue(Settings.KEY_RESTAURANT_ID);
        return voteID;
    }

    @Override
    public void syncronizeVote(String restaurantID) {

        new SyncronizeVote(presenter.getContext(), restaurantID).execute();
    }

    private void processHasVotedToday(ArrayList<Restaurant> restaurants) {

        for (Restaurant r : restaurants) {
            if (!hasVotedToday()) {
                r.setHasVoteToday(false);
            } else if (getVoteID().equalsIgnoreCase(r.getId())) {
                r.setHasVoteToday(true);
            }
        }
    }

    public ArrayList<Restaurant> getRestaurants() {
        ApiService service = new RestClient();
        LocationHelper location = new LocationHelper(presenter.getContext());
        ArrayList<Restaurant> restaurants = service.getRestaurants(location.getLatitude(), location.getLongitude());// -33.856159, 151.215256
        processHasVotedToday(restaurants);
        return restaurants;
    }


    private class SyncronizeVote extends AsyncTask<Void, Void, Void> {

        private ProgressDialog pd;
        private Context context;
        private String restaurantID;
        private String IMEI;

        public SyncronizeVote(Context context, String restaurantID) {
            this.context = context;
            this.restaurantID = restaurantID;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(context, context.getString(R.string.please_wait), context.getString(R.string.send_vote), true, false);
        }

        @Override
        protected Void doInBackground(Void... params) {

            String IMEI = new Util().getIMEI(context);
            ApiService service = new RestClient();
            service.onVote(restaurantID, IMEI);
            //this fake vote mean that the vote will still be controlled
            // by IMEI at server side dont needing any login

            return null;
        }

        @Override
        protected void onPostExecute(Void aAoid) {
            pd.dismiss();
        }

    }

    private  void clearVisited( ArrayList<Restaurant> restaurants ){


        //TODO SYNC VISTED RESTAURANTS

        //TODO REMOVE FROM ARRAY

        //TODO RETURN DATA

        //TODO BINGO!!
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


            publishProgress(null);

            SystemClock.sleep(3000);

            return restaurants;
        }

        @Override
        protected void onProgressUpdate(ArrayList<Restaurant>... values) {
            super.onProgressUpdate(values);

            pd.setMessage("Fake remove restaurant already visited");


        }

        @Override
        protected void onPostExecute(ArrayList<Restaurant> restaurants) {
            pd.dismiss();
            presenter.loadRestaurants(restaurants);
        }

    }


}
