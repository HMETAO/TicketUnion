package com.hmetao.ticketunion.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.hmetao.ticketunion.R;
import com.hmetao.ticketunion.databinding.ActivityMainBinding;
import com.hmetao.ticketunion.ui.adapter.BaseAdapter;
import com.hmetao.ticketunion.ui.fregment.BaseAdapterBuilder;
import com.hmetao.ticketunion.ui.fregment.HomeFragment;
import com.hmetao.ticketunion.ui.fregment.RedPacketFragment;
import com.hmetao.ticketunion.ui.fregment.SearchFragment;
import com.hmetao.ticketunion.ui.fregment.SelectedFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 初始化监听
        initListener();
    }

    private void initListener() {
        BaseAdapter adapter = buildMenusAdapter();
        ViewPager2 vp = binding.mainViewPager;
        BottomNavigationView bnv = binding.mainNavigationBar;
        vp.setAdapter(adapter);
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                bnv.setSelectedItemId(BaseAdapterBuilder.getMenusByPosition(position));
            }
        });


        bnv.setOnItemSelectedListener(item -> {
            vp.setCurrentItem(BaseAdapterBuilder.getPositionByMenuId(item.getItemId()));
            return true;
        });
    }

    private BaseAdapter buildMenusAdapter() {
        return new BaseAdapterBuilder(this)
                .addFragment(new HomeFragment(), R.id.home)
                .addFragment(new SelectedFragment(), R.id.selected)
                .addFragment(new RedPacketFragment(), R.id.red_packet)
                .addFragment(new SearchFragment(), R.id.search)
                .build();
    }
}