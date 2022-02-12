package com.example.data.model.movie

import com.example.data.db.movie.MovieDB
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val backdropPath: String
) {
    fun toConvertMovieRec() = MovieDB(
        title = title,
        overview = overview,
        backdropPath = backdropPath,
        type = "Recommendations"
    )

    fun toConvertMovieRat() = MovieDB(
        title = title,
        overview = overview,
        backdropPath = backdropPath,
        type = "Rated"
    )

    fun toConvertMoviePop() = MovieDB(
        title = title,
        overview = overview,
        backdropPath = backdropPath,
        type = "Favorite"
    )
}