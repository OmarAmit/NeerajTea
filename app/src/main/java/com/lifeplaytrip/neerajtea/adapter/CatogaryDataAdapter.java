package com.lifeplaytrip.neerajtea.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lifeplaytrip.neerajtea.R;
import com.lifeplaytrip.neerajtea.model.CatogaryData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12/20/2017.
 */

public class CatogaryDataAdapter extends RecyclerView.Adapter<CatogaryDataAdapter.MyViewHolder> {

    private Context mContext;
    private List<CatogaryData> catogaryDataList;

    //declare interface
    private CatogaryDataAdapter.Product_OnItemClicked onClick;

    private CatogaryDataAdapter.Product_OnClicked onClicknew;

    public interface Product_OnClicked {
        void Product_onClick(int position);
    }

    //make interface like this
    public interface Product_OnItemClicked {
        void Product_onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView catagory_name, catagory_disc, catagory_price;
        private ImageView catogary_Image;
        private LinearLayout catogaryLinearLayout;
        private Button catagory_button;
        private final Spinner spinner;


        public MyViewHolder(View view) {
            super(view);
            catagory_disc = (TextView) view.findViewById(R.id.catagory_disc);
            catagory_price = (TextView) view.findViewById(R.id.catagory_price);
            catagory_name = (TextView) view.findViewById(R.id.catagory_name);
            catogary_Image = (ImageView) view.findViewById(R.id.catogary_Image);
            catagory_button = (Button) view.findViewById(R.id.catagory_button);
            catogaryLinearLayout = (LinearLayout) view.findViewById(R.id.catogaryLinearLayout);
            spinner = (Spinner) view.findViewById(R.id.spinner);

        }
    }


    public CatogaryDataAdapter(Context mContext, List<CatogaryData> catogaryDataList) {
        this.mContext = mContext;
        this.catogaryDataList = catogaryDataList;
    }

    @Override
    public CatogaryDataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_item, parent, false);

        return new CatogaryDataAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CatogaryDataAdapter.MyViewHolder holder, final int position) {

        final CatogaryData catogaryData = catogaryDataList.get(position);
        holder.catagory_name.setText(catogaryData.getProduct_name());
        holder.catagory_price.setText("Rs. " + catogaryData.getProduct_price() + "");
        Glide.with(mContext).load(catogaryData.getProduct_image()).into(holder.catogary_Image);

        holder.catogaryLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.Product_onItemClick(position);
            }
        });

        holder.catagory_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicknew.Product_onClick(position);

//                Toast.makeText(mContext, "clicked", Toast.LENGTH_LONG).show();
//                Glide.with(mContext).load(R.drawable.ic_favorite_black_18dp).into(holder.ic_wishlist);
            }
        });

        // Spinner Drop down elements
        List<String> quantity = new ArrayList<String>();
        quantity.add("1");
        quantity.add("2");
        quantity.add("3");
        quantity.add("4");
        quantity.add("5");
        quantity.add("6");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, quantity);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        holder.spinner.setAdapter(dataAdapter);
        holder.spinner.setSelection(0);
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                select_item = adapterView.getItemAtPosition(i).toString();
//                item = Integer.parseInt(select_item);
//                holder.product_price.setText("Rs. " + item * cart.getProduct_price() + "");
//                onClick_spin_new.Product_on_spin_Clicked(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    public void setOnClick(CatogaryDataAdapter.Product_OnItemClicked onClick) {
        this.onClick = onClick;
    }

    public void setClick(CatogaryDataAdapter.Product_OnClicked onClicknew) {
        this.onClicknew = onClicknew;
    }

    @Override
    public int getItemCount() {
        return catogaryDataList.size();
    }

}

