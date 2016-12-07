package pragma.team.pragmalunch;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import pragma.team.pragmalunch.common.RestClient;
import pragma.team.pragmalunch.model.Response;
import pragma.team.pragmalunch.model.Restaurant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CompleteSync().execute();
            }
        });


    }


    public class CompleteSync extends AsyncTask<Void, Void, Void> {

        private ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            //  super.onPreExecute();

            pd = ProgressDialog.show(MainActivity.this, "Aguarde", "Atualizando a tabela.", true, false);
        }

        @Override
        protected Void doInBackground(Void... params) {

            RestClient conn = new RestClient();

            List<Restaurant> restaurants = conn.getRestaurants(-30.060626 ,-51.174359 );//)-33.856159, 151.215256);


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();
            //onMatches();
        }
    }

}
