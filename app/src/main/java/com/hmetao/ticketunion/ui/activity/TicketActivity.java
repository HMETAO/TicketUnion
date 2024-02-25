package com.hmetao.ticketunion.ui.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.hmetao.ticketunion.base.BaseActivity;
import com.hmetao.ticketunion.base.TicketManager;
import com.hmetao.ticketunion.databinding.ActivityTicketBinding;
import com.hmetao.ticketunion.model.domain.TicketResult;
import com.hmetao.ticketunion.presenter.TicketPresenter;
import com.hmetao.ticketunion.utils.LogUtils;
import com.hmetao.ticketunion.utils.ToastUtils;
import com.hmetao.ticketunion.view.TicketCallback;

public class TicketActivity extends BaseActivity implements TicketCallback {

    private ActivityTicketBinding binding;
    private TicketPresenter presenter;

    @Override
    protected View getRoot() {
        binding = ActivityTicketBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    protected void loadData() {
        Bundle bundle = getIntent().getExtras();
        presenter.getTicket(
                bundle.getString("title"),
                bundle.getString("url"),
                bundle.getString("cover"));
    }

    @Override
    protected void initPresenter() {
        presenter = TicketManager.getInstance();
        presenter.registerCallback(this);
        PackageManager pm = getPackageManager();
        boolean check = false;
        try {
            PackageInfo packageInfo = pm.getPackageInfo("com.taobao.taobao", PackageManager.MATCH_UNINSTALLED_PACKAGES);
            check = packageInfo != null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (!check) {
            ToastUtils.showToast(this, "请先安装淘宝客户端");
        }


    }

    @Override
    protected void release() {
        presenter.unRegisterCallback(this);
    }

    @Override
    public void networkError() {

    }

    @Override
    public void networkLoading() {
        LogUtils.d("networkLoading");
    }

    @Override
    public void networkEmpty() {

    }

    @Override
    public void networkSuccess() {

    }

    @Override
    public void onTicketLoaded(String cover, TicketResult result) {
        LogUtils.d("onTicketLoaded" + result);
        Glide.with(this).load("https:" + cover).into(binding.ticketCover);
        binding.ticketCode.setText(result.getData().getTbkTpwdCreateResponse().getData().getModel());
    }
}