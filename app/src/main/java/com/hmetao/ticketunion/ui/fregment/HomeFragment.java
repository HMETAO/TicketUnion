package com.hmetao.ticketunion.ui.fregment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hmetao.ticketunion.R;
import com.hmetao.ticketunion.base.BaseFragment;
import com.hmetao.ticketunion.databinding.FragmentHomeBinding;
import com.hmetao.ticketunion.model.domain.Category;
import com.hmetao.ticketunion.presenter.HomePresenter;
import com.hmetao.ticketunion.presenter.impl.HomePresenterImpl;
import com.hmetao.ticketunion.view.HomeCallback;


public class HomeFragment extends BaseFragment implements HomeCallback {


    private FragmentHomeBinding binding;
    private HomePresenter presenter;


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

    }
}