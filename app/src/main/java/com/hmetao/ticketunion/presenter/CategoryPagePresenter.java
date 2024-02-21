package com.hmetao.ticketunion.presenter;

import com.hmetao.ticketunion.base.BasePresenter;
import com.hmetao.ticketunion.view.CategoryPageCallback;

public interface CategoryPagePresenter  {
    void getContentByCategoryId(int categoryId);

    void loadMore(int categoryId);

    void reload(int categoryId);

    void registerCallback(CategoryPageCallback callback, int categoryId);
    void unRegisterCallback(int categoryId);

}
