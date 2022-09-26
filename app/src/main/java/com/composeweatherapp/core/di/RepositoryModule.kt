package com.composeweatherapp.core.di

import com.composeweatherapp.data.repository.RoomRepositoryImpl
import com.composeweatherapp.data.repository.WeatherRepositoryImpl
import com.composeweatherapp.domain.repository.RoomRepository
import com.composeweatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository

    @Binds
    @Singleton
    abstract fun bindRoomRepository(roomRepositoryImpl: RoomRepositoryImpl): RoomRepository
}