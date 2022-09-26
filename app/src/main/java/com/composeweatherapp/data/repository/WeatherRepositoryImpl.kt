package com.composeweatherapp.data.repository

import com.composeweatherapp.data.datasource.remote.api.WeatherApi
import com.composeweatherapp.data.mapper.WeatherDtoMapper
import com.composeweatherapp.domain.model.WeatherData
import com.composeweatherapp.domain.repository.WeatherRepository
import com.composeweatherapp.domain.util.Resource
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val mapper: WeatherDtoMapper
) : WeatherRepository {
    override suspend fun getWeatherDataWithCityName(
        cityName: String,
        apikey: String,
        units: String
    ): Resource<WeatherData> {
        return try {
            Resource.Success(
                mapper.mapFromEntity(
                    api.getWeatherDataWithCityName(cityName, apikey, units  )
                )
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    override suspend fun getWeatherDataWithLocation(
        latitude: Double,
        longitude: Double,
        apikey: String,
        units: String
    ): Resource<WeatherData> {
        return try {
            Resource.Success(
                mapper.mapFromEntity(
                    api.getWeatherDataWithLocation(latitude, longitude, apikey, units)
                )
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}