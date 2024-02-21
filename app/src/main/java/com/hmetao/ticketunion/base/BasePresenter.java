package com.hmetao.ticketunion.base;

import com.hmetao.ticketunion.view.CategoryPageCallback;

public interface BasePresenter<T> {
    void registerCallback(T callback);

    void unRegisterCallback(T callback);

}
