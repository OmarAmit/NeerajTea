package com.lifeplaytrip.neerajtea.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lifeplaytrip.neerajtea.R;
import com.lifeplaytrip.neerajtea.adapter.Viewpager_Adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailFragment extends Fragment {

    /********************code for view pager************************/
    private Viewpager_Adapter viewpager_adapter;
    private ViewPager viewPager;
    private Handler handler;
    private int delay = 4000; //milliseconds
    private int page = 0;
    Runnable runnable;
    /********************code for view pager************************/
    private View view;

    public ProductDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        viewPagerCode();
        return view;
    }

    private void viewPagerCode() {

        /***************(start) code for viewPager*************************/
        String images[] = {
                "https://cdn.grofers.com/app/images/products/full_screen/pro_380157.jpg",
                "https://cdn.grofers.com/app/images/products/sliding_image/380157a.jpg",
                "https://cdn.grofers.com/app/images/products/sliding_image/380157b.jpg",
                "https://cdn.grofers.com/app/images/products/sliding_image/380157c.jpg"
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
        viewPager = (ViewPager) view.findViewById(R.id.productViewpager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.producttabDots);
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
}
