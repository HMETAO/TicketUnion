package com.hmetao.ticketunion.presenter;

import com.hmetao.ticketunion.base.BasePresenter;
import com.hmetao.ticketunion.view.TicketCallback;

public interface TicketPresenter extends BasePresenter<TicketCallback> {

    void getTicket(String title, String url, String cover);

}
