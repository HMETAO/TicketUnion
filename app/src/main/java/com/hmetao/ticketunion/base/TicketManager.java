package com.hmetao.ticketunion.base;

import com.hmetao.ticketunion.presenter.TicketPresenter;
import com.hmetao.ticketunion.presenter.impl.TicketPresenterImpl;

public class TicketManager {
    private static TicketPresenter instance;

    private TicketManager() {
    }

    public static TicketPresenter getInstance() {
        if (instance == null) {
            instance = new TicketPresenterImpl();
        }
        return instance;
    }

}
