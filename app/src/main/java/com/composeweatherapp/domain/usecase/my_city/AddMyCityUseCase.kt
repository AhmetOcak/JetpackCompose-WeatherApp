package com.composeweatherapp.domain.usecase.my_city

import com.composeweatherapp.data.repository.MyCityRepositoryImpl
import com.composeweatherapp.domain.model.MyCity
import javax.inject.Inject

class AddMyCityUseCase @Inject constructor(private val myCityRepositoryImpl: MyCityRepositoryImpl) {
    suspend fun addMyCity(myCity: MyCity) = myCityRepositoryImpl.addMyCity(myCity)
}