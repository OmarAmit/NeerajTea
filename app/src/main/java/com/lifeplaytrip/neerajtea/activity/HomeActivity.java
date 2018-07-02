package com.lifeplaytrip.neerajtea.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.lifeplaytrip.neerajtea.R;
import com.lifeplaytrip.neerajtea.fragment.CartFragment;
import com.lifeplaytrip.neerajtea.fragment.CatogaryDataFragment;
import com.lifeplaytrip.neerajtea.fragment.DueBalanceFragment;
import com.lifeplaytrip.neerajtea.fragment.HistoryFragment;
import com.lifeplaytrip.neerajtea.fragment.HomeFragment;
import com.lifeplaytrip.neerajtea.utils.BagdeDrawable;
import com.lifeplaytrip.neerajtea.utils.Utils;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static FragmentManager fragmentManager;
    public static int itemofcart = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragmentManager = getSupportFragmentManager();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        replaceHomeFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Fragment CatogaryDataFragment = fragmentManager
                    .findFragmentByTag(Utils.CatogaryDataFragment);
            Fragment ProductDetailFragment = fragmentManager
                    .findFragmentByTag(Utils.ProductDetailFragment);
            Fragment CartFragment = fragmentManager
                    .findFragmentByTag(Utils.CartFragment);
            Fragment DueBalanceFragment = fragmentManager
                    .findFragmentByTag(Utils.DueBalanceFragment);
            Fragment HistoryFragment = fragmentManager
                    .findFragmentByTag(Utils.HistoryFragment);
            Fragment HistoryDetailFragment = fragmentManager
                    .findFragmentByTag(Utils.HistoryDetailFragment);

            if (CatogaryDataFragment != null)
                replaceHomeFragment();
            else if (ProductDetailFragment != null)
                replaceHomeFragment();
            else if (DueBalanceFragment != null)
                replaceHomeFragment();
            else if (CartFragment != null)
                replaceHomeFragment();
            else if (HistoryFragment != null)
                replaceHomeFragment();
            else if (HistoryDetailFragment != null)
                replaceHomeFragment();
            else
                super.onBackPressed();
        }
    }

    public void replaceHomeFragment() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, new HomeFragment(),
                        Utils.HomeFragment).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Get the notifications MenuItem and
        // its LayerDrawable (layer-list)
        MenuItem itemCart = menu.findItem(R.id.action_cart);
        LayerDrawable icon = (LayerDrawable) itemCart.getIcon();
        setBadgeCount(this, icon, itemofcart + "");        // force the ActionBar to relayout its MenuItems.
        // onCreateOptionsMenu(Menu) will be called again.
        invalidateOptionsMenu();
        return super.onPrepareOptionsMenu(menu);
    }

    public static void setBadgeCount(Context context, LayerDrawable icon, String count) {

        BagdeDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof BagdeDrawable) {
            badge = (BagdeDrawable) reuse;
        } else {
            badge = new BagdeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_cart) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, new CartFragment(),
                            Utils.CartFragment).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, new HomeFragment(),
                            Utils.HomeFragment).commit();
        } else if (id == R.id.nav_gallery) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, new CatogaryDataFragment(),
                            Utils.CatogaryDataFragment).commit();
        } else if (id == R.id.nav_slideshow) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, new DueBalanceFragment(),
                            Utils.DueBalanceFragment).commit();
        } else if (id == R.id.nav_cart) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, new CartFragment(),
                            Utils.CartFragment).commit();
        } else if (id == R.id.nav_history) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, new HistoryFragment(),
                            Utils.HistoryFragment).commit();
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
