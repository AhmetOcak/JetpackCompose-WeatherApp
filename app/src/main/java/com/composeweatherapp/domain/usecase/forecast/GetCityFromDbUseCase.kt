package com.composeweatherapp.domain.usecase.forecast

import com.composeweatherapp.data.repository.ForecastRepositoryImpl
import javax.inject.Inject

class GetCityFromDbUseCase @Inject constructor(private val forecastRepositoryImpl: ForecastRepositoryImpl) {
    fun getCityFromDb() = forecastRepositoryImpl.getCity()
}