package com.hmetao.ticketunion.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hmetao.ticketunion.R;
import com.hmetao.ticketunion.base.BaseFragment;
import com.hmetao.ticketunion.databinding.FragmentHomePageBinding;
import com.hmetao.ticketunion.model.domain.Category;
import com.hmetao.ticketunion.utils.LogUtils;


public class HomePageFragment extends BaseFragment {

    Category.DataDTO data;

    public HomePageFragment(Category.DataDTO data) {
        this.data = data;

    }

    @Override
    protected void loadData() {
        String title = data.getTitle();
        Integer id = data.getId();
        LogUtils.d("loadData" + title + " " + id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected View loadSuccessView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentHomePageBinding binding = FragmentHomePageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}