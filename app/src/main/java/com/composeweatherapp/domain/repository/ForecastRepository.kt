package com.composeweatherapp.domain.repository

import com.composeweatherapp.domain.model.City
import com.composeweatherapp.domain.model.Forecast
import com.composeweatherapp.core.common.Resource

interface ForecastRepository {
    suspend fun getForecastData(latitude: Double, longitude: Double, ): Resource<Forecast>

    suspend fun getForecastDataWithCityName(cityName: String): Resource<Forecast>

    suspend fun addForecastWeather(forecast: Forecast)

    suspend fun addCity(city: City)

    fun getForecastWeather() : Forecast?

    fun getCity() : City

    suspend fun updateForecastWeather(forecast: Forecast)

    suspend fun updateCity(city: City)
}