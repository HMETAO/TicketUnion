package com.hmetao.ticketunion.presenter.impl;

import com.hmetao.ticketunion.base.BaseFragment;
import com.hmetao.ticketunion.base.RetrofitManager;
import com.hmetao.ticketunion.model.Api;
import com.hmetao.ticketunion.model.domain.Category;
import com.hmetao.ticketunion.presenter.HomePresenter;
import com.hmetao.ticketunion.utils.LogUtils;
import com.hmetao.ticketunion.view.HomeCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenterImpl implements HomePresenter {
    private HomeCallback callback;

    @Override
    public void getCategories() {
        if (callback != null) callback.networkLoading();
        Retrofit retrofit = RetrofitManager.getInstance();
        retrofit.create(Api.class).getCategories().enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    Category category = response.body();
                    assert category != null;
                    LogUtils.d(category.toString());
                    if (callback != null) {
                        if (category.getData().size() == 0) {
                            callback.networkEmpty();
                        } else {
                            callback.networkSuccess();
                        }
                        callback.getCategoriesLoad(category);
                    }
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                LogUtils.e(t.getMessage());
                callback.networkError();
            }
        });
    }

    @Override
    public void registerCallback(HomeCallback callback) {
        this.callback = callback;
    }


    @Override
    public void unRegisterCallback(HomeCallback callback) {
        callback = null;
    }
}
