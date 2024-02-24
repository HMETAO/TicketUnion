package com.hmetao.ticketunion.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRoot());
        initPresenter();
        initView();
        initEvent();
        loadData();
    }

    protected void loadData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        release();
    }

    protected void initPresenter() {
    }

    protected void initEvent() {
    }

    protected void initView() {
    }

    protected void release() {
    }

    protected abstract View getRoot();
}
