package com.ldm.material.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ldm.material.R;
import com.ldm.material.fragment.CardViewFragment;
import com.ldm.material.fragment.CollapsingToolbarFragment;
import com.ldm.material.fragment.CoordinatorFragment;
import com.ldm.material.fragment.MaterialBarsFragment;
import com.ldm.material.fragment.SwiperRefreshFragment;

//DrawerLayout使用
public class DrawerActivity extends AppCompatActivity {
    private DrawerLayout drawer_layout;
    private NavigationView navigation_view;
    private FrameLayout fl_container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        fl_container = (FrameLayout) findViewById(R.id.fl_container);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        }
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer_layout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.float_action_button:
                    case R.id.snack_bar:
                        showContent(new MaterialBarsFragment());
                        break;
                    case R.id.coordinator_layout:
                        showContent(new CoordinatorFragment());
                        break;
                    case R.id.card_view:
                        showContent(new CardViewFragment());
                        break;
                    case R.id.app_bar_layout:
                        Toast.makeText(DrawerActivity.this, "断续补充中...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.swiper_refresh_layout:
                        showContent(new SwiperRefreshFragment());
                        break;
                    case R.id.collapsing_toolbar_layout:
                        showContent(new CollapsingToolbarFragment());
                        break;
                }
                return true;
            }
        });
    }

    private void showContent(Fragment fragment) {
        fl_container.removeAllViews();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, fragment);
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
