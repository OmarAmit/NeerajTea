package com.lifeplaytrip.neerajtea.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lifeplaytrip.neerajtea.R;
import com.lifeplaytrip.neerajtea.adapter.Catogary_Adapter;
import com.lifeplaytrip.neerajtea.adapter.Viewpager_Adapter;
import com.lifeplaytrip.neerajtea.model.Catogary;
import com.lifeplaytrip.neerajtea.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Catogary_Adapter.News_OnItemClicked {

    /********************code for view pager************************/
    private Viewpager_Adapter viewpager_adapter;
    private ViewPager viewPager;
    private Handler handler;
    private int delay = 4000; //milliseconds
    private int page = 0;
    Runnable runnable;
    /********************code for view pager************************/
    private View view;
    private RecyclerView recyclerView;
    private List<Catogary> catogarylist;
    private Catogary_Adapter adapter;
    private Catogary catogary;
    private static FragmentManager fragmentManager;
    private ImageView home_banner1;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        viewPagerCode();

        home_banner1 = (ImageView) view.findViewById(R.id.home_banner1);
        Glide.with(getContext()).load("http://www.teaduniya.com/media/queldorei/shopper/slideshow/banner-1.jpg").into(home_banner1);

        recyclerView = (RecyclerView) view.findViewById(R.id.catogaryRecyclerView);
        catogarylist = new ArrayList<>();
        adapter = new Catogary_Adapter(getContext(), catogarylist);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
//        LinearLayoutManager linearLayoutManager_new = new LinearLayoutManager(getContext());
//        linearLayoutManager_new.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(linearLayoutManager_new);
        adapter.setOnClick(this);
        catogary_ApiCall();
        return view;
    }

    private void viewPagerCode() {

        /***************(start) code for viewPager*************************/
        String images[] = {
                "https://www.bigbasket.com/media/customPage/355c27b8-a44f-4900-a390-8e82c69b8021/67082c92-00fe-4d33-b2bc-20410b312d41/9dbed94e-dc24-47f3-92f2-58099a31c1f2/T1_All_IceCream_DT_2_1130x400_25thMay.jpg",
                "https://cdn.grofers.com/app/images/promotions/merchant/1527662216_super-mom_may_web_1.jpg",
                "https://www.bigbasket.com/media/customPage/355c27b8-a44f-4900-a390-8e82c69b8021/67082c92-00fe-4d33-b2bc-20410b312d41/9dbed94e-dc24-47f3-92f2-58099a31c1f2/T1_All_BigSave_DT_4_1130x400-21stMay.jpg",
        };
        runnable = new Runnable() {
            public void run() {
                if (viewpager_adapter.getCount() == page) {
                    page = 0;
                } else {
                    page++;
                }
                viewPager.setCurrentItem(page, true);
                handler.postDelayed(this, delay);
            }
        };

        handler = new Handler();
        viewPager = (ViewPager) view.findViewById(R.id.homeViewpager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabDots);
        // viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewpager_adapter = new Viewpager_Adapter(getContext(), images);

        viewPager.setAdapter(viewpager_adapter);
        tabLayout.setupWithViewPager(viewPager, true);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        /***************(End) code for viewPager*************************/
    }


    /********************code for view pager************************/

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, delay);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void news_onItemClick(int position) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, new CatogaryDataFragment(),
                        Utils.CatogaryDataFragment).commit();
    }

    private void catogary_ApiCall() {
        catogary = new Catogary("Tea", "https://www.bigbasket.com/media/uploads/p/m/240065_4-tata-tea-gold-leaf-tea.jpg", 1);
        catogarylist.add(catogary);
        catogary = new Catogary("Atta", "https://www.bigbasket.com/media/uploads/p/l/126903_6-aashirvaad-atta-whole-wheat.jpg", 1);
        catogarylist.add(catogary);
        catogary = new Catogary("Sugar", "https://www.bigbasket.com/media/uploads/p/l/10000407_8-bb-royal-sugar.jpg", 1);
        catogarylist.add(catogary);
        catogary = new Catogary("Elaichi", "https://www.bigbasket.com/media/uploads/p/l/40072499_5-bb-royal-organic-cardamomelachi-green.jpg", 1);
        catogarylist.add(catogary);

        adapter.notifyDataSetChanged();
    }
}
