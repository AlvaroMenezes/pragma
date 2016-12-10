package pragma.team.pragmalunch.model.iteractors;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.common.LocationHelper;
import pragma.team.pragmalunch.interfaces.ApiService;
import pragma.team.pragmalunch.interfaces.MainInteractor;
import pragma.team.pragmalunch.interfaces.MainPresenter;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.model.service.RestClient;

/**
 * Created by alvaromenezes on 12/10/16.
 */

public class MainInteractorImpl implements MainInteractor {

    private MainPresenter presenter;

    public MainInteractorImpl(MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showMostVoted() {

        new RequestMostVotedYesterdayTask(presenter.getView().getContext()).execute();
    }


    public Restaurant getMostVotedyesterday() {
        ApiService service = new RestClient();
        //LocationHelper location = new LocationHelper(presenter.getView().getContext());

        double  Latitude =38.7166700;
        double  Longitude= -9.1333300;

        ArrayList<Restaurant> restaurants = service.getRestaurants(Latitude,Longitude);//FAKE LOCATION
        return restaurants.get(0);
    }


    private class RequestMostVotedYesterdayTask extends AsyncTask<Void, Restaurant, Restaurant> {

        private ProgressDialog pd;
        private Context context;

        public RequestMostVotedYesterdayTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(context, context.getString(R.string.please_wait), context.getString(R.string.most_voted_yesterday_load), true, false);
        }

        @Override
        protected Restaurant doInBackground(Void... params) {

            Restaurant restaurants = getMostVotedyesterday();

            return restaurants;
        }

        @Override
        protected void onPostExecute(Restaurant restaurant) {
            pd.dismiss();
            presenter.getView().showMostVoted(restaurant);
        }

    }

}
