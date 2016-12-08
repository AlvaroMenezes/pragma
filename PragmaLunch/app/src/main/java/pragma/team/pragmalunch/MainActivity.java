package pragma.team.pragmalunch;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import pragma.team.pragmalunch.common.RestClient;
import pragma.team.pragmalunch.model.Response;
import pragma.team.pragmalunch.model.Restaurant;
import pragma.team.pragmalunch.view.RestaurantsFragment;

public class MainActivity extends AppCompatActivity  implements RestaurantsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new CompleteSync().execute();

      //  Button b = (Button) findViewById(R.id.button);
        /*b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CompleteSync().execute();
            }
        });*/


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public class CompleteSync extends AsyncTask<Void, Void, Void> {

        private ProgressDialog pd;
        private ArrayList<Restaurant> restaurants = null;

        @Override
        protected void onPreExecute() {
            //  super.onPreExecute();

            pd = ProgressDialog.show(MainActivity.this, "Aguarde", "Atualizando a tabela.", true, false);
        }

        @Override
        protected Void doInBackground(Void... params) {

            RestClient conn = new RestClient();

            restaurants = conn.getRestaurants(-33.856159, 151.215256);//-30.060626, -51.174359);//)


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();

            RestaurantsFragment restaurantsFragment = RestaurantsFragment.newInstance(restaurants);
            final String TAG = restaurantsFragment.getClass().getName();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.activity_main_container, restaurantsFragment, TAG);
            fragmentTransaction.commit();
        }

    }


}
