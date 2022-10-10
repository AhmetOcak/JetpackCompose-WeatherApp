package com.composeweatherapp.presentation.search

import androidx.lifecycle.ViewModel
import com.composeweatherapp.domain.usecase.forecast.GetForecastWithCityNameUseCase
import com.composeweatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchCityViewModel @Inject constructor(
    private val getForecastWithCityName: GetForecastWithCityNameUseCase,
) : ViewModel() {

    private val _searchCityState = MutableStateFlow<SearchCityState>(SearchCityState.Loading)
    val searchCityState = _searchCityState.asStateFlow()

    private suspend fun fetchForecastWithCityName(cityName: String) {
        when (val result = getForecastWithCityName.getForecast(cityName)) {
            is Resource.Success -> {
                _searchCityState.value = SearchCityState.Success(result.data)
            }
            is Resource.Error -> {
                _searchCityState.value = SearchCityState.Error(result.message)
            }
        }
    }
}