package com.hmetao.ticketunion.base;

public interface BaseCallback {
    void networkError();

    void networkLoading();

    void networkEmpty();
    void networkSuccess();
}
