package com.composeweatherapp.data.datasource.local.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.composeweatherapp.data.datasource.local.db.entity.CityEntity
import com.composeweatherapp.data.datasource.local.db.entity.ForecastEntity
import com.composeweatherapp.data.datasource.local.db.entity.MyCityEntity

@Database(entities = [CityEntity::class, ForecastEntity::class, MyCityEntity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

    abstract fun forecastWeatherDao(): ForecastDao

    abstract fun myCityDao(): MyCityDao
}