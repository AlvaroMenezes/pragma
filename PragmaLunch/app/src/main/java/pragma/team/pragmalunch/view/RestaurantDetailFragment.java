package pragma.team.pragmalunch.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.interfaces.OnRestaurantDetailListener;
import pragma.team.pragmalunch.interfaces.RestaurantDetailPresenter;
import pragma.team.pragmalunch.interfaces.RestaurantDetailView;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.presenters.RestaurantDetailPresenterImpl;


public class RestaurantDetailFragment extends Fragment implements RestaurantDetailView {
    private static final String ARG_RESTAURANT = "restaurant";
    private Restaurant mRestaurant;
    private OnRestaurantDetailListener mListener;
    private View view;
    private RestaurantDetailPresenter presenter;

    public RestaurantDetailFragment() {
    }


    @Override
    public View getView() {
        return this.view;
    }

    public static RestaurantDetailFragment newInstance(Restaurant restaurant) {
        RestaurantDetailFragment fragment = new RestaurantDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_RESTAURANT, restaurant);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        Restaurant restaurant = (Restaurant) args.getSerializable(ARG_RESTAURANT);
        view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        presenter = new RestaurantDetailPresenterImpl(this, restaurant);


        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showDetails();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRestaurantDetailListener) {
            mListener = (OnRestaurantDetailListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void showDetails() {
        presenter.showDetails();
    }
}
