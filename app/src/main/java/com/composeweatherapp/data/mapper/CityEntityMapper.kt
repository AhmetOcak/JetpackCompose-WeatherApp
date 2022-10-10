package com.composeweatherapp.data.mapper

import com.composeweatherapp.data.datasource.local.db.entity.CityEntity
import com.composeweatherapp.domain.mapper.IEntityMapper
import com.composeweatherapp.domain.model.City
import com.composeweatherapp.domain.model.Coord
import javax.inject.Inject

class CityEntityMapper @Inject constructor() : IEntityMapper<CityEntity, City> {
    override fun mapFromEntity(entity: CityEntity): City {
        return City(
            entity.country,
            entity.timezone,
            entity.sunrise,
            entity.sunset,
            entity.cityName,
            Coord(
                entity.latitude,
                entity.longitude
            )
        )
    }

    override fun entityFromModel(model: City): CityEntity {
        return CityEntity(
            id = 1,
            country = model.country,
            timezone = model.timezone,
            sunrise = model.sunrise,
            sunset = model.sunset,
            cityName = model.cityName,
            latitude = model.coordinate.latitude,
            longitude = model.coordinate.longitude
        )
    }
}