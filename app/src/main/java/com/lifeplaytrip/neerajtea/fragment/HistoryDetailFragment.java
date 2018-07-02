package com.lifeplaytrip.neerajtea.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lifeplaytrip.neerajtea.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryDetailFragment extends Fragment {
    private TextView user_number, history_name, cart_disc, cart_quantity, cart_price, created_date, status, delivery_date, user_name, user_address;
    private ImageView historyImage;
    private String product_image;
    private View view;

    public HistoryDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_history_detail, container, false);
        initId();
        getdatafromIntent();
        Glide.with(getContext()).load(product_image).into(historyImage);
        return view;
    }

    private void getdatafromIntent() {
        Bundle bundle = getArguments();
        product_image = bundle.getString("image");
        user_address.setText(bundle.getString("p_address"));
        history_name.setText(bundle.getString("p_name"));
        user_name.setText(bundle.getString("u_name"));
        cart_disc.setText(bundle.getString("p_desc"));
        user_number.setText(bundle.getString("u_phone"));
        cart_quantity.setText(bundle.getString("p_quantity"));
        cart_price.setText("Rs. " + bundle.getString("p_price"));
        created_date.setText(bundle.getString("p_created"));
        status.setText(bundle.getString("p_status"));
        delivery_date.setText(bundle.getString("p_deliver"));

    }

    private void initId() {
        user_address = (TextView) view.findViewById(R.id.user_address);
        historyImage = (ImageView) view.findViewById(R.id.historyImage);
        history_name = (TextView) view.findViewById(R.id.history_name);
        user_number = (TextView) view.findViewById(R.id.user_number);
        cart_disc = (TextView) view.findViewById(R.id.cart_disc);
        cart_quantity = (TextView) view.findViewById(R.id.cart_quantity);
        cart_price = (TextView) view.findViewById(R.id.cart_price);
        created_date = (TextView) view.findViewById(R.id.created_date);
        status = (TextView) view.findViewById(R.id.status);
        delivery_date = (TextView) view.findViewById(R.id.delivery_date);
        user_name = (TextView) view.findViewById(R.id.user_name);
        user_address = (TextView) view.findViewById(R.id.user_address);
    }

}
