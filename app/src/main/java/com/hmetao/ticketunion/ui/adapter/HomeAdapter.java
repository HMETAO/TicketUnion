package com.hmetao.ticketunion.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hmetao.ticketunion.databinding.FragmentHomeBinding;
import com.hmetao.ticketunion.model.domain.Category;
import com.hmetao.ticketunion.ui.fragment.HomePageFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends FragmentStateAdapter {

    List<Category.DataDTO> data;

    public HomeAdapter(@NonNull FragmentActivity fragmentActivity, List<Category.DataDTO> data) {
        super(fragmentActivity);
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new HomePageFragment(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(Category category) {
        if (category != null) {
            data = category.getData();
            notifyDataSetChanged();
        }
    }

}
