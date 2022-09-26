package com.composeweatherapp.domain.repository

import com.composeweatherapp.domain.model.WeatherData
import com.composeweatherapp.domain.util.Resource

interface WeatherRepository {
    suspend fun getWeatherDataWithCityName(
        cityName: String,
        apikey: String,
        units: String,
    ): Resource<WeatherData>

    suspend fun getWeatherDataWithLocation(
        latitude: Double,
        longitude: Double,
        apikey: String,
        units: String,
    ): Resource<WeatherData>
}