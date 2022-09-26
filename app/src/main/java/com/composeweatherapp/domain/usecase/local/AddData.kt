package com.composeweatherapp.domain.usecase.local

import com.composeweatherapp.domain.model.WeatherData
import com.composeweatherapp.domain.repository.RoomRepository
import javax.inject.Inject

class AddData @Inject constructor(private val repository: RoomRepository) {
    suspend fun addData(weatherData: WeatherData) {
        repository.addWeatherData(weatherData)
    }
}