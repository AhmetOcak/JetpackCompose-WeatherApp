package com.composeweatherapp.domain.usecase.remote

import com.composeweatherapp.domain.model.WeatherData
import com.composeweatherapp.domain.repository.WeatherRepository
import com.composeweatherapp.domain.util.Resource
import javax.inject.Inject

class GetDataWithCityName @Inject constructor(private val repository: WeatherRepository) {
    suspend fun getDataWithCityName(
        cityName: String,
        apikey: String,
        units: String
    ): Resource<WeatherData> =
        repository.getWeatherDataWithCityName(cityName, apikey, units)
}