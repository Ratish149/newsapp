package com.ratish.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL="https://newsapi.org/v2/";

    @GET("everything")
    Call<News> getNews(
            @Query("q") String query,
            @Query("apiKey") String apiKey
    );
    @GET("everything")
    Call<News> getSortNews(
            @Query("q") String query,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );
    @GET("everything")
    Call<News> getQueryNews(
            @Query("q") String query,
            @Query("apiKey") String apiKey
    );

}
