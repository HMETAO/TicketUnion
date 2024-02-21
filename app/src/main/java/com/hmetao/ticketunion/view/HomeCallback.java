package com.hmetao.ticketunion.view;

import com.hmetao.ticketunion.model.domain.Category;

public interface HomeCallback {

    void getCategoriesLoad(Category category);

    void networkError();

    void networkLoading();

    void networkEmpty();
    void networkSuccess();
}
