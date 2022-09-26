package com.composeweatherapp.data.mapper

import com.composeweatherapp.core.helpers.IEntityMapper
import com.composeweatherapp.data.datasource.local.db.entity.WeatherEntity
import com.composeweatherapp.data.datasource.remote.api.entity.Main
import com.composeweatherapp.data.datasource.remote.api.entity.Sys
import com.composeweatherapp.data.datasource.remote.api.entity.Weather
import com.composeweatherapp.data.datasource.remote.api.entity.Wind
import com.composeweatherapp.domain.model.WeatherData

class WeatherEntityMapper: IEntityMapper<WeatherEntity, WeatherData> {
    override fun mapFromEntity(entity: WeatherEntity): WeatherData {
        return WeatherData(
            Main(entity.temp, entity.feels_like, entity.pressure, entity.humidity),
            Wind(entity.wind_speed),
            listOf(Weather(entity.description)),
            Sys(entity.sunrise, entity.sunset),
            entity.city_name
        )
    }

    override fun entityFromModel(model: WeatherData): WeatherEntity {
        return WeatherEntity(
            temp = model.weatherData.temp,
            feels_like = model.weatherData.feelsLike,
            pressure = model.weatherData.pressure,
            humidity = model.weatherData.humidity,
            wind_speed = model.windSpeed.speed,
            description = model.weatherStatus[0].description,
            sunrise = model.sunTimes.sunrise,
            sunset = model.sunTimes.sunset,
            city_name = model.cityName
        )
    }

}