package com.composeweatherapp.data.datasource.local.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.composeweatherapp.data.datasource.local.db.entity.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao() : WeatherDao
}