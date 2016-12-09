package pragma.team.pragmalunch.presenters;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.interfaces.RestaurantDetailPresenter;
import pragma.team.pragmalunch.interfaces.RestaurantDetailView;
import pragma.team.pragmalunch.model.data.Restaurant;

/**
 * Created by alvaromenezes on 12/9/16.
 */

public class RestaurantDetailPresenterImpl implements RestaurantDetailPresenter , View.OnClickListener{

    private RestaurantDetailView view;
    private Restaurant restaurant;
    private ImageView image;
    private TextView name;
    private TextView cuisine;
    private TextView adress;
    private TextView avg_cost;
    private TextView ratingText;
    private TextView rating;
    private TextView basedVotes;
    private LinearLayout layout;
    private Button buttonBookTable;

    public RestaurantDetailPresenterImpl(RestaurantDetailView view, Restaurant restaurant) {
        this.view = view;
        this.restaurant = restaurant;
        setFields();
        buttonBookTable.setOnClickListener(this);

    }

    private void setFields() {
        name = (TextView) view.getView().findViewById(R.id.fragment_restaurant_detail_name);
        cuisine = (TextView) view.getView().findViewById(R.id.fragment_restaurant_detail_cuisine);
        adress = (TextView) view.getView().findViewById(R.id.fragment_restaurant_detail_addres);
        avg_cost = (TextView) view.getView().findViewById(R.id.fragment_restaurant_detail_average_cost_four_two);

        ratingText = (TextView) view.getView().findViewById(R.id.fragment_restaurant_detail_rating_text);
        rating = (TextView) view.getView().findViewById(R.id.fragment_restaurant_detail_rating);
        basedVotes = (TextView) view.getView().findViewById(R.id.fragment_restaurant_detail_based_votes);

        layout = (LinearLayout) view.getView().findViewById(R.id.rating_layout);
        image = (ImageView) view.getView().findViewById(R.id.fragmant_restaurant_detail_image);
        buttonBookTable = (Button) view.getView().findViewById(R.id.fragment_restaurant_detail_book_table);
    }

    @Override
    public void showDetails() {

        Picasso.with(view.getContext()).load(restaurant.getThumb()).into(image);
        name.setText(restaurant.getName());
        cuisine.setText(restaurant.getCuisines());
        adress.setText(restaurant.getLocation().getAddress());
        avg_cost.setText(restaurant.getCurrency() + restaurant.getAverage_cost_for_two());

        ratingText.setText(restaurant.getUser_rating().getRating_text());
        rating.setText(restaurant.getUser_rating().getAggregate_rating());

        String basedOn = String.format(view.getContext().getString(R.string.based_on), restaurant.getUser_rating().getVotes());
        basedVotes.setText(basedOn);

        layout.setBackgroundColor(Color.parseColor("#" + restaurant.getUser_rating().getRating_color()));

    }

    @Override
    public void openUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        view.getContext().startActivity(i);
    }

    @Override
    public void onClick(View v) {

        openUrl(restaurant.getBook_url());
    }
}
