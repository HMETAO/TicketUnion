package com.hmetao.ticketunion.model;

import com.hmetao.ticketunion.model.domain.Category;
import com.hmetao.ticketunion.model.domain.HomePageContent;
import com.hmetao.ticketunion.model.domain.TicketParams;
import com.hmetao.ticketunion.model.domain.TicketResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    @GET("discovery/categories")
    Call<Category> getCategories();

    @GET("discovery/{materialId}/{page}")
    Call<HomePageContent> getContentByCategoryId(@Path("materialId") int materialId, @Path("page") int page);

    @POST("tpwd")
    Call<TicketResult> getTicket(@Body TicketParams ticketParams);
}
