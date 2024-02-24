package com.hmetao.ticketunion.presenter.impl;

import androidx.annotation.NonNull;

import com.hmetao.ticketunion.base.RetrofitManager;
import com.hmetao.ticketunion.model.Api;
import com.hmetao.ticketunion.model.domain.TicketParams;
import com.hmetao.ticketunion.model.domain.TicketResult;
import com.hmetao.ticketunion.presenter.TicketPresenter;
import com.hmetao.ticketunion.utils.LogUtils;
import com.hmetao.ticketunion.view.TicketCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TicketPresenterImpl implements TicketPresenter {
    private TicketCallback callback;

    @Override
    public void registerCallback(TicketCallback callback) {
        this.callback = callback;
    }

    @Override
    public void unRegisterCallback(TicketCallback callback) {
        callback = null;
    }

    @Override
    public void getTicket(String title, String url, String cover) {
        if (callback != null) callback.networkLoading();
        Retrofit retrofit = RetrofitManager.getInstance();
        retrofit.create(Api.class).getTicket(new TicketParams("https:" + url, title)).enqueue(new Callback<TicketResult>() {
            @Override
            public void onResponse(@NonNull Call<TicketResult> call, @NonNull Response<TicketResult> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
//                    callback.onTicketLoaded();
                    LogUtils.d("onResponse" + response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<TicketResult> call, @NonNull Throwable t) {
                LogUtils.e(t.getMessage());
                callback.networkError();
            }
        });
    }
}
