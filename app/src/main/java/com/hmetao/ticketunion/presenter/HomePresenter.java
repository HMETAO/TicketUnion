package com.hmetao.ticketunion.presenter;

import com.hmetao.ticketunion.base.BasePresenter;
import com.hmetao.ticketunion.view.HomeCallback;

public interface HomePresenter extends BasePresenter<HomeCallback> {

    void getCategories();


}
