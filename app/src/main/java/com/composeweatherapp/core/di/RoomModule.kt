package com.composeweatherapp.core.di

import android.content.Context
import androidx.room.Room
import com.composeweatherapp.data.datasource.local.db.room.WeatherDatabase
import com.composeweatherapp.core.utils.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): WeatherDatabase {
        return Room.databaseBuilder(context, WeatherDatabase::class.java, Database.database_name)
            .allowMainThreadQueries()
            .build()
    }
}