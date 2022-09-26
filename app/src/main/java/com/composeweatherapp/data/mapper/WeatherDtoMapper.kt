package com.composeweatherapp.data.mapper

import com.composeweatherapp.domain.model.WeatherData
import com.composeweatherapp.core.helpers.IEntityMapper
import com.composeweatherapp.data.datasource.remote.api.entity.WeatherDto
import javax.inject.Inject

class WeatherDtoMapper @Inject constructor(): IEntityMapper<WeatherDto, WeatherData> {
    override fun mapFromEntity(entity: WeatherDto): WeatherData {
        return WeatherData(
            entity.weatherData,
            entity.windSpeed,
            entity.weatherStatus,
            entity.sunTimes,
            entity.cityName
        )
    }

    override fun entityFromModel(model: WeatherData): WeatherDto {
        return WeatherDto(
            model.weatherData,
            model.windSpeed,
            model.weatherStatus,
            model.sunTimes,
            model.cityName
        )
    }
}