package com.example.data.api

import com.example.data.BuildConfig
import com.example.data.model.movie.ApiMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/634649/recommendations")
    suspend fun getMoviesRec(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ): ApiMovieResponse

    @GET("movie/top_rated")
    suspend fun getMoviesRat(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ): ApiMovieResponse

    @GET("movie/popular")
    suspend fun getMoviesPop(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ): ApiMovieResponse



}