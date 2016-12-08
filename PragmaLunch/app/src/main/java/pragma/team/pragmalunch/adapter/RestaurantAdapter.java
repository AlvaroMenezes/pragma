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
import pragma.team.pragmalunch.model.Restaurant;

/**
 * Created by alvaromenezes on 12/8/16.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

private ArrayList<Restaurant> restaurants= null;
    private Context context;
/*
public interface OnClickListener {
    void onClick(Match match,View view);
}*/
    public RestaurantAdapter(ArrayList<Restaurant> restaurants ,Context context ){//int round, OnClickListener listener) {
        this.restaurants = restaurants;
        this.context = context;
       // mListener = listener;
        //setMatches();

    }

    private void setMatches() {
      //  matches = new MatchController().getMaches(round);
        //sort();
    }

    public void  refresh(){
        setMatches();
    }





    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,  int position) {
        holder.restaurant = restaurants.get(position);


        holder.name.setText(holder.restaurant.getName());
        holder.cuisine.setText(holder.restaurant.getCuisines());

        Picasso.with(context).load(holder.restaurant.getThumb()).into(holder.thumb);
   // }
/*
        holder.date.setText(holder.match.getDate());//todo formatar
        holder.homeScore.setText(Integer.toString(holder.match.getHomeScore()));
        holder.visitorScore.setText(Integer.toString(holder.match.getVisitorScore()));

        int homeBadgeId = ctrl.getBadgeResId(hometeam.getBadge());
        int visitorBadgeId = ctrl.getBadgeResId(Visitorteam.getBadge());

        holder.homeBadge.setImageResource(homeBadgeId);
        holder.visitorBadge.setImageResource(visitorBadgeId);

      /*  holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {

                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClick(holder.match, v);
                }
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return restaurants.size();

    }

 class ViewHolder extends RecyclerView.ViewHolder  {
    public final View mView;

    public final TextView name;
    public final TextView cuisine;
    public final ImageView thumb;

    public Restaurant restaurant;

    public ViewHolder(View view) {
        super(view);
        mView = view;
        name = (TextView) view.findViewById(R.id.item_restaurant_name);
        cuisine = (TextView) view.findViewById(R.id.item_product_cuisine);
        thumb = (ImageView) view.findViewById(R.id.item_restaurant_thumb);

    }



}
}
