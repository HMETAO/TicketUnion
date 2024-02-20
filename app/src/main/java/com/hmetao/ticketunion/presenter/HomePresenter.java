package com.hmetao.ticketunion.presenter;

import com.hmetao.ticketunion.view.HomeCallback;

public interface HomePresenter {

    void getCategories();

    void registerCallback(HomeCallback callback);

    void unRegisterCallback(HomeCallback callback);

}
