package com.composeweatherapp.domain.usecase.local

import com.composeweatherapp.domain.model.WeatherData
import com.composeweatherapp.domain.repository.RoomRepository
import javax.inject.Inject

class UpdateData @Inject constructor(private val repository: RoomRepository) {
    fun updateData(weatherData: WeatherData) {
        repository.updateWeatherData(weatherData)
    }
}