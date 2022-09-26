package com.composeweatherapp.domain.model

import com.composeweatherapp.data.datasource.remote.api.entity.Main
import com.composeweatherapp.data.datasource.remote.api.entity.Sys
import com.composeweatherapp.data.datasource.remote.api.entity.Weather
import com.composeweatherapp.data.datasource.remote.api.entity.Wind

data class WeatherData(
    val weatherData: Main,
    val windSpeed: Wind,
    val weatherStatus: List<Weather>,
    val sunTimes: Sys,
    val cityName: String,
)


