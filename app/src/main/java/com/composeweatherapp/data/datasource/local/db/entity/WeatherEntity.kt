package com.composeweatherapp.data.datasource.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.composeweatherapp.utils.Database

@Entity(tableName = Database.table_name)
data class WeatherEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "temp")
    var temp: Double,

    @ColumnInfo(name = "feels_like")
    var feels_like: Double,

    @ColumnInfo(name = "pressure")
    var pressure: Double,

    @ColumnInfo(name = "humidity")
    var humidity: Int,

    @ColumnInfo(name = "speed")
    var wind_speed: Double,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "sunrise")
    var sunrise: Long,

    @ColumnInfo(name = "sunset")
    var sunset: Long,

    @ColumnInfo(name = "name")
    var city_name: String,
)