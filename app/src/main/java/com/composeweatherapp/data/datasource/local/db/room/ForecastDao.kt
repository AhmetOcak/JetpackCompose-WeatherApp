package com.composeweatherapp.data.datasource.local.db.room

import androidx.room.*
import com.composeweatherapp.data.datasource.local.db.entity.ForecastEntity

@Dao
interface ForecastDao {
    @Insert
    suspend fun addForecastWeather(forecastEntity: ForecastEntity)

    @Query("SELECT * FROM forecast_data")
    fun getForecastWeather(): List<ForecastEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateForecastWeather(forecastEntity: ForecastEntity)
}