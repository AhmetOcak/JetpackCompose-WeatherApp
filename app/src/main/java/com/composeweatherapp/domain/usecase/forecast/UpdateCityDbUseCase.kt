package com.composeweatherapp.domain.usecase.forecast

import com.composeweatherapp.data.repository.ForecastRepositoryImpl
import com.composeweatherapp.domain.model.City
import javax.inject.Inject

class UpdateCityDbUseCase @Inject constructor(private val forecastRepositoryImpl: ForecastRepositoryImpl) {
    suspend fun updateCityDb(city: City) = forecastRepositoryImpl.updateCity(city)
}