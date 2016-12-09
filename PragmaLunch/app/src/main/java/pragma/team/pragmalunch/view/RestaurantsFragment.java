package pragma.team.pragmalunch.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.adapter.RestaurantAdapter;
import pragma.team.pragmalunch.interfaces.OnRestaurantDetailListener;
import pragma.team.pragmalunch.interfaces.RestaurantsPresenter;
import pragma.team.pragmalunch.interfaces.RestaurantsView;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.presenters.RestaurantsPresenterImpl;


public class RestaurantsFragment extends Fragment implements RestaurantsView {
    private RecyclerView recyclerView;
    private RestaurantsPresenter presenter;
    private OnRestaurantDetailListener mListener;

    public RestaurantsFragment() {
    }

    public static RestaurantsFragment newInstance() {
        RestaurantsFragment fragment = new RestaurantsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RestaurantsPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);
        setupList(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.syncronize();
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
    public void setupList(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void loadRestaurants(ArrayList<Restaurant> restaurants) {


        final RestaurantAdapter adapter = new RestaurantAdapter(restaurants, getContext(), mListener);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (recyclerView.getAdapter() == null) {
                    recyclerView.setAdapter(adapter);
                } else {
                    recyclerView.swapAdapter(adapter, true);
                }
            }
        });


    }


}
