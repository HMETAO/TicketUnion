package com.hmetao.ticketunion.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hmetao.ticketunion.R;
import com.hmetao.ticketunion.databinding.FragmentBaseBinding;

public abstract class BaseFragment extends Fragment {
    private State currentState;
    private View mSuccessView;
    private View mLoadingView;
    private View mErrorView;
    private View mEmptyView;

    public enum State {
        NONE, LOADING, SUCCESS, ERROR, EMPTY
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBaseBinding binding = FragmentBaseBinding.inflate(inflater, container, false);
        // 绑定p
        initPresenter();
        // 加载view
        loadStatesView(inflater, container, savedInstanceState, binding.container);
        // 加载数据
        loadData();
        return binding.getRoot();
    }

    /**
     * 加载各种状态的View
     */
    private void loadStatesView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, FrameLayout root) {
        //成功的view
        mSuccessView = loadSuccessView(inflater, container, savedInstanceState);
        root.addView(mSuccessView);
        //Loading的View
        mLoadingView = loadLoadingView(inflater, container, savedInstanceState);
        root.addView(mLoadingView);
        //错误页面
        mErrorView = loadErrorView(inflater, container, savedInstanceState);
        root.addView(mErrorView);
        //内容为空的页面
        mEmptyView = loadEmptyView(inflater, container, savedInstanceState);
        root.addView(mEmptyView);
        setUpState(State.NONE);
    }


    /**
     * 子类通过这个方法来切换状态页面即可
     */
    public void setUpState(State state) {
        this.currentState = state;
        mSuccessView.setVisibility(currentState == State.SUCCESS ? View.VISIBLE : View.GONE);
        mLoadingView.setVisibility(currentState == State.LOADING ? View.VISIBLE : View.GONE);
        mErrorView.setVisibility(currentState == State.ERROR ? View.VISIBLE : View.GONE);
        mEmptyView.setVisibility(currentState == State.EMPTY ? View.VISIBLE : View.GONE);
    }

    protected abstract View loadSuccessView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected View loadErrorView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_error, container, false);
    }

    protected View loadLoadingView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loading, container, false);
    }

    protected View loadEmptyView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_empty, container, false);
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
