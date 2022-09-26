package com.composeweatherapp.data.datasource.remote.api

import com.composeweatherapp.data.datasource.remote.api.entity.WeatherDto
import com.composeweatherapp.utils.NetworkService
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(NetworkService.END_POINT)
    suspend fun getWeatherDataWithCityName(
        @Query("q") cityName: String,
        @Query("APPID") apikey: String,
        @Query("units") units: String,
    ): WeatherDto

    @GET(NetworkService.END_POINT)
    suspend fun getWeatherDataWithLocation(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("APPID") apiKey: String,
        @Query("units") units: String,
    ): WeatherDto
}