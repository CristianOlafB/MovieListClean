package com.example.data.api

import com.example.data.BuildConfig
import com.example.data.model.tv.ApiTVResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceTv {

    @GET("tv/130392/recommendations")
    suspend fun getTvRec(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ): ApiTVResponse

    @GET("tv/top_rated")
    suspend fun getTvRat(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ): ApiTVResponse

    @GET("tv/popular")
    suspend fun getTvPop(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ): ApiTVResponse

}