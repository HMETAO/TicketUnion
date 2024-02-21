package com.hmetao.ticketunion.view;

import com.hmetao.ticketunion.model.domain.HomePageContent;

public interface CategoryPageCallback {
    void getContentByCategoryIdLoad(HomePageContent homePageContent);

    void networkError(int categoryId);

    void networkLoading(int categoryId);

    void networkEmpty(int categoryId);

    void networkSuccess(int categoryId);

    void loadMoreError(int categoryId);

    void loadMoreEmpty(int categoryId);

    void onLoaderMoreLoaded(HomePageContent homePageContent);

    void onLooperListLoaded(HomePageContent homePageContent);
}
