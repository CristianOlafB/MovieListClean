package com.example.data.model.movie


import com.google.gson.annotations.SerializedName

data class ApiMovieResponse(
    @SerializedName("results")
    val movies: List<Result>
)