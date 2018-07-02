package com.lifeplaytrip.neerajtea.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lifeplaytrip.neerajtea.R;
import com.lifeplaytrip.neerajtea.adapter.HistoryAdapter;
import com.lifeplaytrip.neerajtea.model.History;
import com.lifeplaytrip.neerajtea.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements HistoryAdapter.Product_OnItemClicked {

    private RecyclerView recyclerView;
    private HistoryAdapter adapter = null;
    private List<History> historyList;
    private History history;
    private View view;
    private static FragmentManager fragmentManager;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_history, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();

        /*****************(Start) code For Card View*****************/

        recyclerView = (RecyclerView) view.findViewById(R.id.history_recyclerView);
        historyList = new ArrayList<>();
        adapter = new HistoryAdapter(getContext(), historyList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnClick(this);
        signupRequest();
        /*****************(End) code For Card View Vertical*****************/

        return view;
    }

    private void signupRequest() {
        history = new History("Tea", "Neeraj Tea", 1, "https://www.bigbasket.com/media/uploads/p/m/240065_4-tata-tea-gold-leaf-tea.jpg", "100", 1, "pending", "5", "10/12/2018", "12/12/2018", "Amit", "9898909089", "Sohna road Gurgaon");
        historyList.add(history);
        history = new History("Tea", "Neeraj Tea", 1, "https://www.bigbasket.com/media/uploads/p/m/240065_4-tata-tea-gold-leaf-tea.jpg", "100", 1, "pending", "5", "10/12/2018", "12/12/2018", "Amit", "9898909089", "Sohna road Gurgaon");
        historyList.add(history);
        history = new History("Tea", "Neeraj Tea", 1, "https://www.bigbasket.com/media/uploads/p/m/240065_4-tata-tea-gold-leaf-tea.jpg", "100", 1, "pending", "5", "10/12/2018", "12/12/2018", "Amit", "9898909089", "Sohna road Gurgaon");
        historyList.add(history);
        history = new History("Tea", "Neeraj Tea", 1, "https://www.bigbasket.com/media/uploads/p/m/240065_4-tata-tea-gold-leaf-tea.jpg", "100", 1, "pending", "5", "10/12/2018", "12/12/2018", "Amit", "9898909089", "Sohna road Gurgaon");
        historyList.add(history);
        history = new History("Tea", "Neeraj Tea", 1, "https://www.bigbasket.com/media/uploads/p/m/240065_4-tata-tea-gold-leaf-tea.jpg", "100", 1, "pending", "5", "10/12/2018", "12/12/2018", "Amit", "9898909089", "Sohna road Gurgaon");
        historyList.add(history);

    }

    @Override
    public void Product_onItemClick(int position) {
        sendDatatoHistoryDetailFragment();
    }

    private void sendDatatoHistoryDetailFragment() {
        Fragment fragment = new HistoryDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("image", history.getProduct_image());
        bundle.putString("p_name", history.getProduct_name());
        bundle.putString("p_desc", history.getProduct_discription());
        bundle.putString("p_price", history.getProduct_price());
        bundle.putString("p_created", history.getProduct_created());
        bundle.putString("p_deliver", history.getProduct_deliver());
        bundle.putString("p_status", history.getProduct_status());
        bundle.putString("u_name", history.getUser_name());
        bundle.putString("u_phone", history.getUser_phone());
        bundle.putString("p_address", history.getUser_address());
        bundle.putString("p_quantity", history.getProduct_quantity());

        fragment.setArguments(bundle);
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.container, fragment,
                        Utils.HistoryDetailFragment).commit();
    }

}
