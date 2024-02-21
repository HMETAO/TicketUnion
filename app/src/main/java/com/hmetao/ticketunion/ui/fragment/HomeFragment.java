package com.hmetao.ticketunion.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.google.android.material.tabs.TabLayoutMediator;
import com.hmetao.ticketunion.base.BaseFragment;
import com.hmetao.ticketunion.databinding.FragmentHomeBinding;
import com.hmetao.ticketunion.model.domain.Category;
import com.hmetao.ticketunion.presenter.HomePresenter;
import com.hmetao.ticketunion.presenter.impl.HomePresenterImpl;
import com.hmetao.ticketunion.ui.adapter.HomeAdapter;
import com.hmetao.ticketunion.utils.LogUtils;
import com.hmetao.ticketunion.view.HomeCallback;


public class HomeFragment extends BaseFragment implements HomeCallback {


    private FragmentHomeBinding binding;
    private HomePresenter presenter;
    private HomeAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initPresenter() {
        presenter = new HomePresenterImpl();
        presenter.registerCallback(this);
    }

    @Override
    protected void loadData() {
        presenter.getCategories();
    }

    @Override
    protected void release() {
        if (presenter != null) presenter.unRegisterCallback(this);
    }

    @Override
    public void getCategoriesLoad(Category category) {
        if (adapter == null) {
            initViewPager(category);
        } else {
            adapter.setData(category);
        }
    }

    private void initViewPager(Category category) {
        adapter = new HomeAdapter(requireActivity(), category.getData());
        binding.vp.setAdapter(adapter);
        // 设置tabLayout
        new TabLayoutMediator(binding.tl, binding.vp, (tab, position) -> {
            tab.setText(category.getData().get(position).getTitle());
        }).attach();
    }
}