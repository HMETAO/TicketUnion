package com.hmetao.ticketunion.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hmetao.ticketunion.ui.fregment.BaseAdapterBuilder;
import com.hmetao.ticketunion.ui.fregment.HomeFragment;

import java.util.Objects;

public class BaseAdapter extends FragmentStateAdapter {
    public BaseAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return Objects.requireNonNull(BaseAdapterBuilder.fragmentMap.getOrDefault(position, new HomeFragment()));
    }

    @Override
    public int getItemCount() {
        return BaseAdapterBuilder.len;
    }
}
