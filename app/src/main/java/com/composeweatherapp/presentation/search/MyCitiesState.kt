package com.composeweatherapp.presentation.search

import com.composeweatherapp.domain.model.MyCity

sealed interface MyCitiesState {
    data class Success(val forecast: List<MyCity>?): MyCitiesState
    data class Error(val errorMessage: String?): MyCitiesState

    object Loading: MyCitiesState
}