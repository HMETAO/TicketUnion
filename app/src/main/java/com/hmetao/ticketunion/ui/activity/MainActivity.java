package com.hmetao.ticketunion.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hmetao.ticketunion.R;
import com.hmetao.ticketunion.base.BaseActivity;
import com.hmetao.ticketunion.base.BaseAdapterBuilder;
import com.hmetao.ticketunion.databinding.ActivityMainBinding;
import com.hmetao.ticketunion.ui.adapter.BaseAdapter;
import com.hmetao.ticketunion.ui.fragment.HomeFragment;
import com.hmetao.ticketunion.ui.fragment.RedPacketFragment;
import com.hmetao.ticketunion.ui.fragment.SearchFragment;
import com.hmetao.ticketunion.ui.fragment.SelectedFragment;
import com.hmetao.ticketunion.utils.LogUtils;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View getRoot() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    protected void initView() {
        // 初始化监听
        initListener();
    }

    private void initListener() {
        BaseAdapter adapter = buildMenusAdapter();
        ViewPager2 vp = binding.mainViewPager;
        vp.setOffscreenPageLimit(1);
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
        LogUtils.d("初始化监听完成");
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