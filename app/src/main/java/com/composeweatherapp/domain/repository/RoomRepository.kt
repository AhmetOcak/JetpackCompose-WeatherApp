package com.composeweatherapp.domain.repository

import com.composeweatherapp.domain.model.WeatherData

interface RoomRepository {

    suspend fun addWeatherData(weatherData: WeatherData)

    fun getWeatherData(): WeatherData

    fun updateWeatherData(weatherData: WeatherData)
}