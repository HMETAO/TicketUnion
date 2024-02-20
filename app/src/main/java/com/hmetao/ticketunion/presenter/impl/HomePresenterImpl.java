package com.hmetao.ticketunion.presenter.impl;

import com.hmetao.ticketunion.base.RetrofitManager;
import com.hmetao.ticketunion.model.Api;
import com.hmetao.ticketunion.model.domain.Category;
import com.hmetao.ticketunion.presenter.HomePresenter;
import com.hmetao.ticketunion.ui.fregment.HomeFragment;
import com.hmetao.ticketunion.utils.LogUtils;
import com.hmetao.ticketunion.view.HomeCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenterImpl implements HomePresenter {
    @Override
    public void getCategories() {
        Retrofit retrofit = RetrofitManager.getInstance();
        retrofit.create(Api.class).getCategories().enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    Category body = response.body();
                    assert body != null;
                    LogUtils.d(body.toString());
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                LogUtils.e(t.getMessage());

            }
        });
    }

    @Override
    public void registerCallback(HomeCallback callback) {

    }


    @Override
    public void unRegisterCallback(HomeCallback callback) {

    }
}
