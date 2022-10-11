package com.composeweatherapp.domain.usecase.my_city

import com.composeweatherapp.data.repository.MyCityRepositoryImpl
import com.composeweatherapp.domain.model.MyCity
import javax.inject.Inject

class UpdateMyCityUseCase @Inject constructor(private val myCityRepositoryImpl: MyCityRepositoryImpl) {
    suspend fun updateMyCityUseCase(myCity: MyCity) = myCityRepositoryImpl.updateMyCity(myCity)
}