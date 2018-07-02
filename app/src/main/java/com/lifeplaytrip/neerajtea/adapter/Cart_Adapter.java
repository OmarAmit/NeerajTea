package com.lifeplaytrip.neerajtea.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lifeplaytrip.neerajtea.R;
import com.lifeplaytrip.neerajtea.model.CatogaryData;

import java.util.List;

import static com.lifeplaytrip.neerajtea.activity.HomeActivity.itemofcart;

/**
 * Created by LifePlayTrip on 6/2/2018.
 */

public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.MyViewHolder> {

    private Context mContext;
    private List<CatogaryData> cartList;

    //declare interface
    private Cart_Adapter.Product_OnItemClicked onClick;

    private Cart_Adapter.Product_OnClicked onClicknew;

    public interface Product_OnClicked {
        void Product_onClick(int position);
    }

    //make interface like this
    public interface Product_OnItemClicked {
        void Product_onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView cart_name, cart_disc, cart_price;
        private ImageView cart_Image;
        private LinearLayout cartLinearLayout;
        private Button cart_button;

        public MyViewHolder(View view) {
            super(view);
            cart_disc = (TextView) view.findViewById(R.id.cart_disc);
            cart_price = (TextView) view.findViewById(R.id.cart_price);
            cart_name = (TextView) view.findViewById(R.id.cart_name);
            cart_Image = (ImageView) view.findViewById(R.id.cart_Image);
            cart_button = (Button) view.findViewById(R.id.cart_button);
            cartLinearLayout = (LinearLayout) view.findViewById(R.id.cartLinearLayout);
        }
    }


    public Cart_Adapter(Context mContext, List<CatogaryData> cartList) {
        this.mContext = mContext;
        this.cartList = cartList;
    }

    @Override
    public Cart_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_cart_item, parent, false);

        return new Cart_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Cart_Adapter.MyViewHolder holder, final int position) {

        final CatogaryData catogaryData = cartList.get(position);
        holder.cart_name.setText(catogaryData.getProduct_name());
        holder.cart_price.setText("Rs. " + catogaryData.getProduct_price() + "");
        Glide.with(mContext).load(catogaryData.getProduct_image()).into(holder.cart_Image);

        holder.cartLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.Product_onItemClick(position);
            }
        });

        holder.cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicknew.Product_onClick(position);
                removeItem(position);
                itemofcart--;
                notifyDataSetChanged();
//                Toast.makeText(mContext, "clicked", Toast.LENGTH_LONG).show();
//                Glide.with(mContext).load(R.drawable.ic_favorite_black_18dp).into(holder.ic_wishlist);
            }
        });
    }


    public void setOnClick(Cart_Adapter.Product_OnItemClicked onClick) {
        this.onClick = onClick;
    }

    public void setClick(Cart_Adapter.Product_OnClicked onClicknew) {
        this.onClicknew = onClicknew;
    }

    //
    public void removeItem(int position) {
        cartList.remove(position);
//        // notify the item removed by position
//         to perform recycler view delete animations
//         NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
//
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

}
