package com.hmetao.ticketunion.ui.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
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
    private boolean check = false;

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
        check = isAppInstalled(this, "com.taobao.taobao");
        if (!check) {
            ToastUtils.showToast(this, "请先安装淘宝客户端");
        }
    }

    private boolean isAppInstalled(Context context, String uri) {
        PackageManager pm = context.getPackageManager();
        boolean installed;
        try {
            pm.getPackageInfo(uri, PackageManager.MATCH_UNINSTALLED_PACKAGES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }

    @Override
    protected void initEvent() {
        binding.ticketCopyOrOpenBtn.setOnClickListener(v -> {
            String code = binding.ticketCode.getText().toString();
            ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setPrimaryClip(ClipData.newPlainText("ticket", code));
            if (!check) {
                ToastUtils.showToast(this, "复制成功");
            } else {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.taobao.taobao");
                startActivity(intent);
            }
        });
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