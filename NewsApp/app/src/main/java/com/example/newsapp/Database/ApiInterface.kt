package com.example.newsapp.Database

import com.example.newsapp.Models.Headline
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    fun getHeadlines( @Query("country") country: String?,
                      @Query("apiKey") apiKey: String?
    ) : Call<Headline>

    @GET("everything")
    fun getSpecificData( @Query("q") query: String?,
                      @Query("apiKey") apiKey: String?
    ) : Call<Headline>

}
