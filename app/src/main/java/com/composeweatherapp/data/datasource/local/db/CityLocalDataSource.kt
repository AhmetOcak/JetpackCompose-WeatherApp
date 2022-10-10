package com.composeweatherapp.data.datasource.local.db

import com.composeweatherapp.data.datasource.local.db.entity.CityEntity
import com.composeweatherapp.data.datasource.local.db.room.CityDao
import javax.inject.Inject

class CityLocalDataSource @Inject constructor(private val cityDao: CityDao) {

    suspend fun addCity(cityEntity: CityEntity) =
        cityDao.addCity(cityEntity)

    fun getCity() = cityDao.getCity()

    suspend fun updateCity(cityEntity: CityEntity) =
        cityDao.updateCity(cityEntity)
}