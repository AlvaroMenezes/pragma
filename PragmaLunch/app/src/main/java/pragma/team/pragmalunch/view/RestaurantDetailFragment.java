package pragma.team.pragmalunch.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.interfaces.RestaurantDetailPresenter;
import pragma.team.pragmalunch.interfaces.RestaurantDetailView;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.presenters.RestaurantDetailPresenterImpl;


public class RestaurantDetailFragment extends Fragment implements RestaurantDetailView {
    private static final String ARG_RESTAURANT = "restaurant";
    private View view;
    private RestaurantDetailPresenter presenter;

    public RestaurantDetailFragment() {
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
    public View getView() {
        return view;
    }

    @Override
    public void showDetails() {
        presenter.showDetails();
    }
}
