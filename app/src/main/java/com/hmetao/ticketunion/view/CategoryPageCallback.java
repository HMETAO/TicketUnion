package com.hmetao.ticketunion.view;

import com.hmetao.ticketunion.base.BaseCallback;
import com.hmetao.ticketunion.model.domain.HomePageContent;

import java.util.List;

public interface CategoryPageCallback extends BaseCallback {
    void getContentByCategoryIdLoad(HomePageContent homePageContent);

    void networkSuccess(int categoryId);

    void loadMoreError(int categoryId);

    void loadMoreEmpty(int categoryId);

    void onLoaderMoreLoaded(HomePageContent homePageContent);

    void onLooperListLoaded(List<HomePageContent.DataDTO> dataDTOS);
}
