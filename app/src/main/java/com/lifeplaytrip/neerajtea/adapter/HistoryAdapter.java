package com.lifeplaytrip.neerajtea.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lifeplaytrip.neerajtea.R;
import com.lifeplaytrip.neerajtea.model.History;


import java.util.List;

/**
 * Created by user on 1/9/2018.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<History> historyList;

    //declare interface
    private HistoryAdapter.Product_OnItemClicked onClick;

    //make interface like this
    public interface Product_OnItemClicked
    {
        void Product_onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView product_name, product_discription, product_price, text_del_status;
        private ImageView product_image;
        private LinearLayout cartLinearLayout;

        public MyViewHolder(View view) {
            super(view);
            product_discription = (TextView) view.findViewById(R.id.cart_disc);
            product_price = (TextView) view.findViewById(R.id.cart_price);
            product_name = (TextView) view.findViewById(R.id.cart_name);
            product_image = (ImageView) view.findViewById(R.id.cartImage);
            cartLinearLayout = (LinearLayout) view.findViewById(R.id.cartLinearLayout);
            text_del_status = (TextView) view.findViewById(R.id.text_del_status);
        }
    }


    public HistoryAdapter(Context mContext, List<History> historyList) {
        this.mContext = mContext;
        this.historyList = historyList;
    }

    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_history, parent, false);

        return new HistoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final HistoryAdapter.MyViewHolder holder, final int position)
    {

        final History history = historyList.get(position);
        holder.product_discription.setText(history.getProduct_discription());
        holder.product_name.setText(history.getProduct_name());
        holder.product_price.setText("Rs. " + history.getProduct_price() + "");
        holder.text_del_status.setText(history.getProduct_status() + history.getProduct_deliver());
        Glide.with(mContext).load(history.getProduct_image()).into(holder.product_image);
        Log.d("Image", history.getProduct_image());

        holder.cartLinearLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                onClick.Product_onItemClick(position);
            }
        });
    }

    public void setOnClick(HistoryAdapter.Product_OnItemClicked onClick)
    {
        this.onClick = onClick;
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

}


