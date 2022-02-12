package com.example.data.model.tv

import com.example.data.db.tv.TvDB
import com.google.gson.annotations.SerializedName

data class ResultTv(
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val backdropPath: String
) {
    fun toConvertTvRec() = TvDB(
        original_name = originalName,
        overview = overview,
        backdropPath = backdropPath,
        type = "Recommendations"
    )

    fun toConvertTvRat() = TvDB(
        original_name = originalName,
        overview = overview,
        backdropPath = backdropPath,
        type = "Rated"
    )

    fun toConvertTvPop() = TvDB(
        original_name = originalName,
        overview = overview,
        backdropPath = backdropPath,
        type = "Favorite"
    )
}