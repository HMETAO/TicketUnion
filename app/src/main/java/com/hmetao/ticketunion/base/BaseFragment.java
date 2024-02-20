package com.hmetao.ticketunion.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        loadData();
    }

    protected void initPresenter() {

    }

    protected void loadData() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        release();
    }

    protected void release() {
    }
}
