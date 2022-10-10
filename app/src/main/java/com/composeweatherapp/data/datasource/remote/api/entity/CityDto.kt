package com.composeweatherapp.data.datasource.remote.api.entity

import com.google.gson.annotations.SerializedName

data class CityDto(
    @SerializedName("country") val country: String,
    @SerializedName("timezone") val timezone: Int,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long,
    @SerializedName("name") val cityName: String,
    @SerializedName("coord") val coordinate: CoordDto
)
