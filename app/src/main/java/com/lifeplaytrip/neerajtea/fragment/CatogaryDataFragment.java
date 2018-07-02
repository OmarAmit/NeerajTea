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
import com.lifeplaytrip.neerajtea.adapter.CatogaryDataAdapter;
import com.lifeplaytrip.neerajtea.adapter.Catogary_Adapter;
import com.lifeplaytrip.neerajtea.model.Catogary;
import com.lifeplaytrip.neerajtea.model.CatogaryData;
import com.lifeplaytrip.neerajtea.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatogaryDataFragment extends Fragment implements CatogaryDataAdapter.Product_OnClicked, CatogaryDataAdapter.Product_OnItemClicked {
    private View view;
    private RecyclerView recyclerView;
    private CatogaryDataAdapter adapter = null;
    private List<CatogaryData> catogaryDataList;
    private CatogaryData catogaryData;
    private static FragmentManager fragmentManager;

    public CatogaryDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentProductAdapter
        view = inflater.inflate(R.layout.fragment_catogary_data, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();

        /*****************(Start) code For Card View*****************/

        recyclerView = (RecyclerView) view.findViewById(R.id.catogaryDataRecyclearView);
        catogaryDataList = new ArrayList<>();
        adapter = new CatogaryDataAdapter(getContext(), catogaryDataList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnClick(this);
        adapter.setClick(this);

        catogary_ApiCall();
        /*****************(End) code For Card View Vertical*****************/

        return view;
    }

    private void catogary_ApiCall() {
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/m/240065_4-tata-tea-gold-leaf-tea.jpg", "250", "200", "redxwsa");
        catogaryDataList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/126903_6-aashirvaad-atta-whole-wheat.jpg", "250", "200", "redxwsa");
        catogaryDataList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/10000407_8-bb-royal-sugar.jpg", "250", "200", "redxwsa");
        catogaryDataList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/40072499_5-bb-royal-organic-cardamomelachi-green.jpg", "250", "200", "redxwsa");
        catogaryDataList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/m/240065_4-tata-tea-gold-leaf-tea.jpg", "250", "200", "redxwsa");
        catogaryDataList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/126903_6-aashirvaad-atta-whole-wheat.jpg", "250", "200", "redxwsa");
        catogaryDataList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/10000407_8-bb-royal-sugar.jpg", "250", "200", "redxwsa");
        catogaryDataList.add(catogaryData);
        catogaryData = new CatogaryData("Tea Supreme Gold", 1, "https://www.bigbasket.com/media/uploads/p/l/40072499_5-bb-royal-organic-cardamomelachi-green.jpg", "250", "200", "redxwsa");
        catogaryDataList.add(catogaryData);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void Product_onClick(int position) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, new CartFragment(),
                        Utils.CartFragment).commit();
    }

    @Override
    public void Product_onItemClick(int position) {

        fragmentManager
                .beginTransaction()
                .replace(R.id.container, new ProductDetailFragment(),
                        Utils.ProductDetailFragment).commit();
    }
}
