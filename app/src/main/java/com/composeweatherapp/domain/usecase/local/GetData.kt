package com.composeweatherapp.domain.usecase.local

import com.composeweatherapp.domain.model.WeatherData
import com.composeweatherapp.domain.repository.RoomRepository
import javax.inject.Inject

class GetData @Inject constructor(private val repository: RoomRepository) {
    fun getData(): WeatherData = repository.getWeatherData()
}