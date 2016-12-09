package pragma.team.pragmalunch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.interfaces.OnRestaurantDetailListener;
import pragma.team.pragmalunch.model.data.Restaurant;

/**
 * Created by alvaromenezes on 12/8/16.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private ArrayList<Restaurant> restaurants = null;
    private Context context;

    private OnRestaurantDetailListener restaurantDetailListener;
    //private OnVoteListener onVoteListener;

    public interface OnDetailListener {
        void onClick(Restaurant restaurant);
    }

    public interface OnVoteListener {
        void onClick(Restaurant restaurant);
    }

    public RestaurantAdapter(ArrayList<Restaurant> restaurants, Context context, OnRestaurantDetailListener restaurantDetailListener) {
        this.restaurants = restaurants;
        this.context = context;
        this.restaurantDetailListener = restaurantDetailListener;
        // this.onVoteListener = onVoteListener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.restaurant = restaurants.get(position);
        holder.name.setText(holder.restaurant.getName());
        holder.cuisine.setText(holder.restaurant.getCuisines());
        holder.adress.setText(holder.restaurant.getLocation().getAddress());

        holder.votesTotal.setText(String.valueOf(holder.restaurant.getVotes()));


        Picasso.with(context).load(holder.restaurant.getThumb()).into(holder.thumb);

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restaurantDetailListener.showDetail(holder.restaurant);
            }
        });

        holder.vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // onVoteListener.onClick(holder.restaurant);
            }
        });

    }


    @Override
    public int getItemCount() {
        return restaurants.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final TextView name;
        public final TextView adress;
        public final TextView cuisine;
        public final TextView votesTotal;
        public final ImageView thumb;
        public final ImageView vote;
        public final ImageView detail;

        public Restaurant restaurant;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = (TextView) view.findViewById(R.id.item_restaurant_name);
            cuisine = (TextView) view.findViewById(R.id.item_restaurant_cuisine);
            adress = (TextView) view.findViewById(R.id.item_restaurant_addres);
            votesTotal = (TextView) view.findViewById(R.id.item_restaurant_votes_total);
            thumb = (ImageView) view.findViewById(R.id.item_restaurant_thumb);
            vote = (ImageView) view.findViewById(R.id.item_restaurant_vote);
            detail = (ImageView) view.findViewById(R.id.item_restaurant_detail);


        }


    }
}
