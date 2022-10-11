package com.composeweatherapp.domain.usecase.my_city

import com.composeweatherapp.data.repository.MyCityRepositoryImpl
import javax.inject.Inject

class GetMyCityUseCase @Inject constructor(private val myCityRepositoryImpl: MyCityRepositoryImpl) {
    fun getMyCity() = myCityRepositoryImpl.getMyCity()
}