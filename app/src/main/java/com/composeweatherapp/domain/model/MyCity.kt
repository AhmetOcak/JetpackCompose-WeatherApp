package com.composeweatherapp.domain.model

data class MyCity(
    var temp: Double,
    var latitude: Double,
    var longitude: Double,
    var cityName: String,
    var country: String,
    var description: String,
    var weatherImage: Int
)
