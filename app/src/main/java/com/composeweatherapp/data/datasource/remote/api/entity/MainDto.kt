package com.composeweatherapp.data.datasource.remote.api.entity

import com.google.gson.annotations.SerializedName

data class MainDto(
    @SerializedName("temp") val temp: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("pressure") val pressure: Double,
    @SerializedName("humidity") val humidity: Int,
)
