package com.hmetao.ticketunion.model;

import com.hmetao.ticketunion.model.domain.Category;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("discovery/categories")
    Call<Category> getCategories();
}
