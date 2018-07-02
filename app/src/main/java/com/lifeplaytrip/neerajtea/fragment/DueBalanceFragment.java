package com.lifeplaytrip.neerajtea.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lifeplaytrip.neerajtea.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DueBalanceFragment extends Fragment {
    private View view;

    public DueBalanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_due_balance, container, false);
        return view;
    }

}
