package com.composeweatherapp.data.datasource.local.db

import com.composeweatherapp.data.datasource.local.db.entity.MyCityEntity
import com.composeweatherapp.data.datasource.local.db.room.MyCityDao
import javax.inject.Inject

class MyCityLocalDataSource @Inject constructor(private val myCityDao: MyCityDao) {

    suspend fun addMyCity(myCityEntity: MyCityEntity) = myCityDao.addCity(myCityEntity)

    fun getMyCity() = myCityDao.getMyCity()

    fun deleteMyCity(cityName: String) = myCityDao.deleteMyCity(cityName)

    suspend fun updateMyCity(
        temp: Double,
        latitude: Double,
        longitude: Double,
        cityName: String,
        description: String,
        weatherImage: Int
    ) = myCityDao.updateMyCity(temp, latitude, longitude, cityName, description, weatherImage)

    suspend fun getSpecificCity(cityName: String) = myCityDao.getSpecificCity(cityName)
}