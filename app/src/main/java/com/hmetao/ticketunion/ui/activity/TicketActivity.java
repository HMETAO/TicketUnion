package com.hmetao.ticketunion.ui.activity;

import android.view.View;

import com.hmetao.ticketunion.base.BaseActivity;
import com.hmetao.ticketunion.base.TicketManager;
import com.hmetao.ticketunion.databinding.ActivityTicketBinding;
import com.hmetao.ticketunion.model.domain.TicketResult;
import com.hmetao.ticketunion.presenter.TicketPresenter;
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
    protected void initPresenter() {
        presenter = TicketManager.getInstance();
        presenter.registerCallback(this);
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

    }

    @Override
    public void networkEmpty() {

    }

    @Override
    public void networkSuccess() {

    }

    @Override
    public void onTicketLoaded(String cover, TicketResult result) {

    }
}