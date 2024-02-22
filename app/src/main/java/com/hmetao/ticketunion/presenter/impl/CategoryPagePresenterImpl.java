package com.hmetao.ticketunion.presenter.impl;

import androidx.annotation.NonNull;

import com.hmetao.ticketunion.base.RetrofitManager;
import com.hmetao.ticketunion.model.Api;
import com.hmetao.ticketunion.model.domain.HomePageContent;
import com.hmetao.ticketunion.presenter.CategoryPagePresenter;
import com.hmetao.ticketunion.utils.LogUtils;
import com.hmetao.ticketunion.view.CategoryPageCallback;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CategoryPagePresenterImpl implements CategoryPagePresenter {
    HashMap<Integer, Integer> pageInfo = new HashMap<>();

    private static final CategoryPagePresenterImpl instance = new CategoryPagePresenterImpl();

    HashMap<Integer, CategoryPageCallback> map = new HashMap<>();

    public static CategoryPagePresenterImpl getInstance() {
        return instance;
    }

    private CategoryPagePresenterImpl() {
    }


    @Override
    public void getContentByCategoryId(int categoryId) {
        CategoryPageCallback callback = map.get(categoryId);
        if (callback == null) {
            LogUtils.e(categoryId + "未获取到callback");
            return;
        }
        // 开启loading状态
        callback.networkLoading();
        Retrofit retrofit = RetrofitManager.getInstance();
        retrofit.create(Api.class)
                .getContentByCategoryId(categoryId, pageInfo.getOrDefault(categoryId, 1))
                .enqueue(new Callback<HomePageContent>() {
                    @Override
                    public void onResponse(@NonNull Call<HomePageContent> call, @NonNull Response<HomePageContent> response) {
                        if (response.code() == HttpURLConnection.HTTP_OK) {
                            HomePageContent body = response.body();
                            assert body != null;
                            LogUtils.d(body.toString());
                            List<HomePageContent.DataDTO> list = body.getData();
                            if (list == null || list.size() == 0)
                                callback.networkEmpty();
                            else {
                                callback.getContentByCategoryIdLoad(body);
                                callback.onLooperListLoaded(list.subList(list.size() - 5, list.size()));
                                callback.networkSuccess();
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<HomePageContent> call, @NonNull Throwable t) {
                        LogUtils.e(t.getMessage());
                        callback.networkError();
                    }
                });
    }

    @Override
    public void loadMore(int categoryId) {

    }

    @Override
    public void reload(int categoryId) {

    }

    @Override
    public void registerCallback(CategoryPageCallback callback, int categoryId) {
        map.put(categoryId, callback);
    }

    @Override
    public void unRegisterCallback(int categoryId) {
        map.remove(categoryId);
    }
}
