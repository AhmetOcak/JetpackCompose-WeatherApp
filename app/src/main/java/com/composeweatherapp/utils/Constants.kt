package com.composeweatherapp.utils

object NetworkService {
    const val BASE_URL: String = "https://api.openweathermap.org"
    const val API_KEY: String = "YOUR API KEY"
    const val UNITS: String = "metric"
    const val END_POINT = "/data/2.5/weather/"
}

object Database {
    const val table_name = "weather_data"
    const val database_name = "weather_data.db"
}