package com.composeweatherapp.data.datasource.local.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.composeweatherapp.data.datasource.local.db.entity.WeatherEntity

@Dao
interface WeatherDao {

    @Insert
    suspend fun addWeatherData(weatherData: WeatherEntity)

    @Query("SELECT * FROM weather_data")
    fun getWeatherData(): WeatherEntity

    @Update
    fun updateWeatherData(weatherData: WeatherEntity)
}