package com.lifeplaytrip.neerajtea.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lifeplaytrip.neerajtea.R;
import com.lifeplaytrip.neerajtea.activity.HomeActivity;
import com.lifeplaytrip.neerajtea.activity.MainActivity;
import com.lifeplaytrip.neerajtea.adapter.Cart_Adapter;
import com.lifeplaytrip.neerajtea.adapter.CatogaryDataAdapter;
import com.lifeplaytrip.neerajtea.model.CatogaryData;
import com.lifeplaytrip.neerajtea.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static com.lifeplaytrip.neerajtea.activity.HomeActivity.itemofcart;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment implements Cart_Adapter.Product_OnClicked, Cart_Adapter.Product_OnItemClicked, View.OnClickListener {

    private View view;
    private RecyclerView recyclerView;
    private Cart_Adapter adapter = null;
    private List<CatogaryData> cartList;
    private CatogaryData catogaryData;
    private static FragmentManager fragmentManager;
    private TextView text_shopMore, text_paymentPage;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        /*****************(Start) code For Card View*****************/
        initView();
        setListeners();
        itemofcart = 7;

        cartList = new ArrayList<>();
        adapter = new Cart_Adapter(getContext(), cartList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnClick(this);
        adapter.setClick(this);
        setCartLayout();
        catogary_ApiCall();
        /*****************(End) code For Card View Vertical*****************/
        return view;
    }

    private void initView() {
        recyclerView = (RecyclerView) view.findViewById(R.id.cart_recyclerView);
        text_shopMore = (TextView) view.findViewById(R.id.text_shopMore);
        text_paymentPage = (TextView) view.findViewById(R.id.text_paymentPage);
    }

    @Override
    public void Product_onClick(int position) {
        setCartLayout();

    }

    @Override
    public void Product_onItemClick(int position) {

    }

    protected void setCartLayout() {
        LinearLayout layoutCartItems = (LinearLayout) view.findViewById(R.id.layout_items);
        LinearLayout layoutCartPayments = (LinearLayout) view.findViewById(R.id.layout_payment);
        LinearLayout layoutCartNoItems = (LinearLayout) view.findViewById(R.id.layout_cart_empty);

        if (itemofcart > 0) {
            layoutCartNoItems.setVisibility(View.GONE);
            layoutCartItems.setVisibility(View.VISIBLE);
            layoutCartPayments.setVisibility(View.VISIBLE);
        } else {
            layoutCartNoItems.setVisibility(View.VISIBLE);
            layoutCartItems.setVisibility(View.GONE);
            layoutCartPayments.setVisibility(View.GONE);

            Button bStartShopping = (Button) view.findViewById(R.id.bAddNew);
            bStartShopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // startActivity(new Intent(CartActivity.this, ShoppingActivity.class));
                }
            });
        }
    }

    // Set Listeners
    private void setListeners() {
        text_shopMore.setOnClickListener(this);
        text_paymentPage.setOnClickListener(this);
    }

    private void catogary_ApiCall() {
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/40072499_5-bb-royal-organic-cardamomelachi-green.jpg", "250", "200", "redxwsa");
        cartList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/m/240065_4-tata-tea-gold-leaf-tea.jpg", "250", "200", "redxwsa");
        cartList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/126903_6-aashirvaad-atta-whole-wheat.jpg", "250", "200", "redxwsa");
        cartList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/10000407_8-bb-royal-sugar.jpg", "250", "200", "redxwsa");
        cartList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/40072499_5-bb-royal-organic-cardamomelachi-green.jpg", "250", "200", "redxwsa");
        cartList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/m/240065_4-tata-tea-gold-leaf-tea.jpg", "250", "200", "redxwsa");
        cartList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/126903_6-aashirvaad-atta-whole-wheat.jpg", "250", "200", "redxwsa");
        cartList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/10000407_8-bb-royal-sugar.jpg", "250", "200", "redxwsa");
        cartList.add(catogaryData);


        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_shopMore:
                new HomeActivity().replaceHomeFragment();
                break;

            case R.id.text_paymentPage:
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.container, new PaymentModeFragment(),
                                Utils.PaymentModeFragment).commit();
                break;
        }

    }
}
