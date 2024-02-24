package com.hmetao.ticketunion.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.hmetao.ticketunion.base.BaseFragment;
import com.hmetao.ticketunion.base.TicketManager;
import com.hmetao.ticketunion.databinding.FragmentHomePageBinding;
import com.hmetao.ticketunion.model.domain.Category;
import com.hmetao.ticketunion.model.domain.HomePageContent;
import com.hmetao.ticketunion.presenter.TicketPresenter;
import com.hmetao.ticketunion.presenter.impl.CategoryPagePresenterImpl;
import com.hmetao.ticketunion.ui.activity.TicketActivity;
import com.hmetao.ticketunion.ui.adapter.HomePageAdapter;
import com.hmetao.ticketunion.utils.LogUtils;
import com.hmetao.ticketunion.utils.ToastUtils;
import com.hmetao.ticketunion.view.CategoryPageCallback;

import java.util.ArrayList;
import java.util.List;


public class HomePageFragment extends BaseFragment implements CategoryPageCallback, HomePageAdapter.OnItemClickListener {

    Category.DataDTO data;
    private CategoryPagePresenterImpl presenter;
    private FragmentHomePageBinding binding;
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
        binding.root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int height = binding.root.getMeasuredHeight();
                LogUtils.d("onGlobalLayout" + height);
                ViewGroup.LayoutParams layoutParams = binding.rv.getLayoutParams();

                layoutParams.height = height;
                binding.rv.setLayoutParams(layoutParams);

                int height1 = binding.llTitle.getMeasuredHeight();
                binding.nestedScrollView.setHeight(height1);
                if (height != 0 && height1 != 0) {
                    binding.root.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
        adapter = new HomePageAdapter();
        adapter.setOnItemClickListener(this);
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
        ToastUtils.showToast(getContext(), "加载更多失败");
    }

    @Override
    public void loadMoreEmpty() {
        ToastUtils.showToast(getContext(), "已全加载完毕");
    }

    @Override
    public void onLoaderMoreLoaded(HomePageContent homePageContent) {
        List<HomePageContent.DataDTO> current = adapter.getCurrentList();
        List<HomePageContent.DataDTO> data = homePageContent.getData();
        ToastUtils.showToast(getContext(), "加载了" + data.size() + "条数据");
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

    @Override
    public void onItemClick(HomePageContent.DataDTO data) {
        LogUtils.d(data.toString());
        Intent intent = new Intent(getContext(), TicketActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        TicketPresenter instance = TicketManager.getInstance();
        instance.getTicket(data.getTitle(), data.getClickUrl(), data.getPictUrl());
        startActivity(intent);
    }


}