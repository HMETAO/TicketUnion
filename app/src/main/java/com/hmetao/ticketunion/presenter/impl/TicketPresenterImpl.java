package com.hmetao.ticketunion.presenter.impl;

import com.hmetao.ticketunion.presenter.TicketPresenter;
import com.hmetao.ticketunion.view.TicketCallback;

public class TicketPresenterImpl implements TicketPresenter {
    private TicketCallback callback;

    @Override
    public void registerCallback(TicketCallback callback) {
        this.callback = callback;
    }

    @Override
    public void unRegisterCallback(TicketCallback callback) {
        callback = null;
    }

    @Override
    public void getTicket(String title, String url, String cover) {

    }
}
