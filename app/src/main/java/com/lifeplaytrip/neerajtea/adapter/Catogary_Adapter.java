package com.lifeplaytrip.neerajtea.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lifeplaytrip.neerajtea.R;
import com.lifeplaytrip.neerajtea.model.Catogary;

import java.util.List;

/**
 * Created by LifePlayTrip on 5/30/2018.
 */

public class Catogary_Adapter extends RecyclerView.Adapter<Catogary_Adapter.MyViewHolder> {
    private Context context;
    private List<Catogary> catogaryList;

    //declare interface
    private Catogary_Adapter.News_OnItemClicked onClick;

    //make interface like this
    public interface News_OnItemClicked {
        void news_onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView cat_textView;
        public ImageView cat_imageView;
        public CardView cardview;

        public MyViewHolder(View view) {
            super(view);
            cat_imageView = (ImageView) view.findViewById(R.id.cat_imageView);
            cat_textView = (TextView) view.findViewById(R.id.cat_textView);
            cardview = (CardView) view.findViewById(R.id.cardview);
        }
    }

    public Catogary_Adapter(Context context, List<Catogary> catogaryList) {
        this.context = context;
        this.catogaryList = catogaryList;
    }

    @Override
    public Catogary_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_catogary, parent, false);

        return new Catogary_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Catogary_Adapter.MyViewHolder holder, final int position) {
        Catogary catogary = catogaryList.get(position);
        holder.cat_textView.setText(catogary.getCat_name());
        Glide.with(context).load(catogary.getCat_image()).into(holder.cat_imageView);
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.news_onItemClick(position);
            }
        });
    }

    public void setOnClick(Catogary_Adapter.News_OnItemClicked onClick) {
        this.onClick = onClick;
    }

    @Override
    public int getItemCount() {
        return catogaryList.size();
    }
}
