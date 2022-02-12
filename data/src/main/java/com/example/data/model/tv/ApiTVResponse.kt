package com.example.data.model.tv


import com.google.gson.annotations.SerializedName

data class ApiTVResponse(
    @SerializedName("results")
    val results: List<ResultTv>
)