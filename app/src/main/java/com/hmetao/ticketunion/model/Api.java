package com.hmetao.ticketunion.model;

import com.hmetao.ticketunion.model.domain.Category;
import com.hmetao.ticketunion.model.domain.HomePageContent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface Api {
    @GET("discovery/categories")
    Call<Category> getCategories();

    @GET("discovery/{materialId}/{page}")
    Call<HomePageContent> getContentByCategoryId(@Path("materialId") int materialId, @Path("page") int page);
}
