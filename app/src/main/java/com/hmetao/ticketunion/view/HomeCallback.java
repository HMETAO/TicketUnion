package com.hmetao.ticketunion.view;

import com.hmetao.ticketunion.base.BaseCallback;
import com.hmetao.ticketunion.model.domain.Category;

public interface HomeCallback extends BaseCallback {

    void getCategoriesLoad(Category category);


}
