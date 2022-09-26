package com.composeweatherapp.domain.usecase.remote

import com.composeweatherapp.domain.model.WeatherData
import com.composeweatherapp.domain.repository.WeatherRepository
import com.composeweatherapp.domain.util.Resource
import javax.inject.Inject

class GetDataWithLocation @Inject constructor(private val repository: WeatherRepository) {
    suspend fun getDataWithLocation(
        latitude: Double,
        longitude: Double,
        apikey: String,
        units: String,
    ): Resource<WeatherData> =
        repository.getWeatherDataWithLocation(latitude, longitude, apikey, units)
}