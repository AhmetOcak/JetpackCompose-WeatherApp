package com.composeweatherapp.domain.usecase.my_city

import com.composeweatherapp.data.repository.MyCityRepositoryImpl
import javax.inject.Inject

class GetSpecificCityUseCase @Inject constructor(private val myCityRepositoryImpl: MyCityRepositoryImpl) {
    suspend fun getSpecificCityUseCase(cityName: String) =
        myCityRepositoryImpl.getSpecificCity(cityName)
}