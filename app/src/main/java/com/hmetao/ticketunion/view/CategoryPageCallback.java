package com.hmetao.ticketunion.view;

import com.hmetao.ticketunion.base.BaseCallback;
import com.hmetao.ticketunion.model.domain.HomePageContent;

import java.util.List;

public interface CategoryPageCallback extends BaseCallback {
    void getContentByCategoryIdLoad(HomePageContent homePageContent);

    void loadMoreError();

    void loadMoreEmpty();

    void onLoaderMoreLoaded(HomePageContent homePageContent);

    void onLooperListLoaded(List<HomePageContent.DataDTO> dataDTOS);
}
