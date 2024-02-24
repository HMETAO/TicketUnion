package com.hmetao.ticketunion.view;

import com.hmetao.ticketunion.base.BaseCallback;
import com.hmetao.ticketunion.model.domain.TicketResult;

public interface TicketCallback extends BaseCallback {

    void onTicketLoaded(String cover, TicketResult result);

}
