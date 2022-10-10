package com.composeweatherapp.domain.usecase.forecast

import com.composeweatherapp.data.repository.ForecastRepositoryImpl
import com.composeweatherapp.domain.model.City
import javax.inject.Inject

class AddCityDbUseCase @Inject constructor(private val forecastRepositoryImpl: ForecastRepositoryImpl) {
    suspend fun addCityDb(city: City) = forecastRepositoryImpl.addCity(city)
}