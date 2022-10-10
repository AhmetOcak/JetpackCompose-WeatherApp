package com.composeweatherapp.data.datasource.remote.api.entity

import com.google.gson.annotations.SerializedName

data class ForecastWeatherDto(
    @SerializedName("main") val weatherData: MainDto,
    @SerializedName("weather") val weatherStatus: List<WeatherDto>,
    @SerializedName("wind") val wind: WindDto,
    @SerializedName("dt_txt") val date: String,
    @SerializedName("clouds") val cloudinessDto: CloudinessDto
)
