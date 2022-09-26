package com.composeweatherapp.data.repository

import com.composeweatherapp.data.datasource.local.db.room.WeatherDao
import com.composeweatherapp.data.mapper.WeatherEntityMapper
import com.composeweatherapp.domain.model.WeatherData
import com.composeweatherapp.domain.repository.RoomRepository
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val dao: WeatherDao,
    private val mapper: WeatherEntityMapper
) : RoomRepository {
    override suspend fun addWeatherData(weatherData: WeatherData) {
        dao.addWeatherData(mapper.entityFromModel(weatherData))
    }

    override fun getWeatherData(): WeatherData {
        return mapper.mapFromEntity(dao.getWeatherData())
    }

    override fun updateWeatherData(weatherData: WeatherData) {
        dao.updateWeatherData(mapper.entityFromModel(weatherData))
    }
}