package com.hmetao.ticketunion.presenter;

import com.hmetao.ticketunion.base.BasePresenter;
import com.hmetao.ticketunion.view.CategoryPageCallback;

public interface CategoryPagePresenter extends BasePresenter<CategoryPageCallback> {
    void getContentByCategoryId(int categoryId);

    void loadMore(int categoryId);

    void reload(int categoryId);


}
