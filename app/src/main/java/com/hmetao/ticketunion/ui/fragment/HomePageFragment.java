package com.hmetao.ticketunion.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.hmetao.ticketunion.base.BaseFragment;
import com.hmetao.ticketunion.databinding.FragmentHomePageBinding;
import com.hmetao.ticketunion.model.domain.Category;
import com.hmetao.ticketunion.model.domain.HomePageContent;
import com.hmetao.ticketunion.presenter.impl.CategoryPagePresenterImpl;
import com.hmetao.ticketunion.ui.adapter.HomePageAdapter;
import com.hmetao.ticketunion.utils.LogUtils;
import com.hmetao.ticketunion.view.CategoryPageCallback;

import java.util.ArrayList;
import java.util.List;


public class HomePageFragment extends BaseFragment implements CategoryPageCallback {

    Category.DataDTO data;
    private CategoryPagePresenterImpl presenter;
    private com.hmetao.ticketunion.databinding.FragmentHomePageBinding binding;
    private HomePageAdapter adapter;

    public HomePageFragment(Category.DataDTO data) {
        this.data = data;
    }

    @Override
    protected void initPresenter() {
        presenter = CategoryPagePresenterImpl.getInstance();
        presenter.registerCallback(this, data.getId());
    }

    @Override
    protected void release() {
        if (presenter != null) presenter = null;
    }

    @Override
    protected void loadData() {
        String title = data.getTitle();
        Integer id = data.getId();
        LogUtils.d("loadData" + title + " " + id);
        if (presenter != null) {
            presenter.getContentByCategoryId(id);
        }
    }

    @Override
    protected void initView(FrameLayout root) {
        adapter = new HomePageAdapter();
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.refreshLayout.setOnLoadMoreListener(refreshLayout -> {
            if (presenter != null) {
                presenter.loadMore(data.getId());
            }
        });
    }


    @Override
    protected View loadSuccessView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomePageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void getContentByCategoryIdLoad(HomePageContent homePageContent) {
        // 更新UI
        adapter.submitList(homePageContent.getData());
    }


    @Override
    public void loadMoreError() {
    }

    @Override
    public void loadMoreEmpty() {

    }

    @Override
    public void onLoaderMoreLoaded(HomePageContent homePageContent) {
        List<HomePageContent.DataDTO> current = adapter.getCurrentList();
        List<HomePageContent.DataDTO> data = homePageContent.getData();
        ArrayList<HomePageContent.DataDTO> list = new ArrayList<>(current.size() + data.size());
        list.addAll(current);
        list.addAll(data);
        adapter.submitList(list);
        binding.refreshLayout.finishLoadMore();
    }

    @Override
    public void onLooperListLoaded(List<HomePageContent.DataDTO> dataDTOS) {

    }

    @Override
    public void networkError() {
        setUpState(State.ERROR);
    }

    @Override
    public void networkLoading() {
        setUpState(State.LOADING);

    }

    @Override
    public void networkEmpty() {
        setUpState(State.EMPTY);
    }

    @Override
    public void networkSuccess() {
        setUpState(State.SUCCESS);
    }
}