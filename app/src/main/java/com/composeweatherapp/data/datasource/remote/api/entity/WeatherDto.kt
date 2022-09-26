package com.composeweatherapp.data.datasource.remote.api.entity

data class WeatherDto(
    val weatherData: Main,
    val windSpeed: Wind,
    val weatherStatus: List<Weather>,
    val sunTimes: Sys,
    val cityName: String,
)

data class Main(
    val temp: Double,
    val feelsLike: Double,
    val pressure: Double,
    val humidity: Int,
)

data class Sys(
    val sunrise: Long,
    val sunset: Long,
)

data class Weather(
    val description: String,
)

data class Wind(
    val speed: Double,
)

