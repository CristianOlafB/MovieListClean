package com.example.domain.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tv(
    val originalName: String?,
    val overview: String?,
    val backdrop_path: String?
) {
    companion object {
        const val HIGH_IMG = "https://image.tmdb.org/t/p/w500"
    }
}