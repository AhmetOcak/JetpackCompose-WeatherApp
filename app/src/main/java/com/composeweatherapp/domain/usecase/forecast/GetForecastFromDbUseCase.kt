package com.composeweatherapp.domain.usecase.forecast

import com.composeweatherapp.data.repository.ForecastRepositoryImpl
import com.composeweatherapp.domain.model.Forecast
import javax.inject.Inject

class GetForecastFromDbUseCase @Inject constructor(private val forecastRepositoryImpl: ForecastRepositoryImpl) {
    fun getForecastFromDbUseCase() : Forecast? = forecastRepositoryImpl.getForecastWeather()
}