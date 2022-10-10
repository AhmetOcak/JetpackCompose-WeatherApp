package com.composeweatherapp.domain.model

data class ForecastWeather(
    val id: Int = 1,
    val weatherData: Main,
    val weatherStatus: List<Weather>,
    val wind: Wind,
    val date: String,
    val cloudiness: Cloudiness
)
