package com.composeweatherapp.presentation.search

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composeweatherapp.core.helpers.HourConverter
import com.composeweatherapp.domain.model.MyCity
import com.composeweatherapp.domain.usecase.forecast.GetForecastWithCityNameUseCase
import com.composeweatherapp.domain.usecase.my_city.*
import com.composeweatherapp.core.common.Resource
import com.composeweatherapp.core.utils.Constants
import com.composeweatherapp.core.utils.WeatherType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class SearchCityViewModel @Inject constructor(
    private val getForecastWithCityName: GetForecastWithCityNameUseCase,
    private val getMyCityUseCase: GetMyCityUseCase,
    private val addMyCityUseCase: AddMyCityUseCase,
    private val deleteMyCityUseCase: DeleteMyCityUseCase,
    private val updateMyCityUseCase: UpdateMyCityUseCase,
    private val getSpecificCityUseCase: GetSpecificCityUseCase
) : ViewModel() {

    private val _searchCityState = MutableStateFlow<SearchCityState>(SearchCityState.Loading)
    val searchCityState = _searchCityState.asStateFlow()

    private val _myCitiesState = MutableStateFlow<MyCitiesState>(MyCitiesState.Loading)
    val myCitiesState = _myCitiesState.asStateFlow()

    var searchFieldValue by mutableStateOf("")
        private set

    var isCitySearched by mutableStateOf(false)
        private set

    init {
        loadMyCities()
    }

    fun errorOnClick() {
        _searchCityState.value = SearchCityState.Success(null)
    }

    fun searchCityClick() {
        isCitySearched = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (checkSearchFieldValue()) {
                    fetchForecastWithCityName(searchFieldValue)
                } else {
                    _searchCityState.value = SearchCityState.Error(Constants.FILL_FIELD)
                }
            } catch (e: Exception) {
                _searchCityState.value = SearchCityState.Error(e.message)
            }
        }
    }

    private fun loadMyCities() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (isMyCitiesExist()) {
                    updateMyCity()
                } else {
                    _myCitiesState.value = MyCitiesState.Success(emptyList())
                }
            } catch (e: Exception) {
                _myCitiesState.value = MyCitiesState.Error(e.message)
            }
        }
    }

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

    fun addMyCity(myCity: MyCity) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (!getSpecificCityUseCase.getSpecificCityUseCase(myCity.cityName)) {
                    addMyCityUseCase.addMyCity(myCity)
                    loadMyCities()
                } else {
                    Log.e("add city", "you have already added this city")
                }
            } catch (e: Exception) {
                Log.e("e", e.message.toString())
            }
        }
    }

    fun removeMyCity(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                deleteMyCityUseCase.deleteMyCityUseCase(cityName)
                loadMyCities()
            } catch (e: Exception) {
                Log.e("e", e.message.toString())
            }
        }
    }

    // no internet connection -> load cities from database
    // internet connection -> update our cities
    private fun updateMyCity() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getMyCityUseCase.getMyCity().forEach { myCity ->
                    when (val result = getForecastWithCityName.getForecast(myCity.cityName)) {
                        is Resource.Success -> {
                            if (result.data != null) {
                                updateMyCityUseCase.updateMyCityUseCase(
                                    MyCity(
                                        temp = result.data.weatherList[0].weatherData.temp,
                                        latitude = result.data.cityDtoData.coordinate.latitude,
                                        longitude = result.data.cityDtoData.coordinate.longitude,
                                        cityName = result.data.cityDtoData.cityName,
                                        country = result.data.cityDtoData.country,
                                        description = result.data.weatherList[0].weatherStatus[0].description,
                                        weatherImage = WeatherType.setWeatherType(
                                            mainDescription = result.data.weatherList[0].weatherStatus[0].mainDescription,
                                            weatherDescription = result.data.weatherList[0].weatherStatus[0].description,
                                            HourConverter.convertHour(
                                                result.data.weatherList[0].date.substring(
                                                    11,
                                                    13
                                                )
                                            ),
                                        )
                                    )
                                )
                                _myCitiesState.value =
                                    MyCitiesState.Success(getMyCityUseCase.getMyCity())
                            }
                        }
                        is Resource.Error -> {
                            if (result.message == Constants.UNKNOWN_HOST) {
                                _myCitiesState.value =
                                    MyCitiesState.Success(getMyCityUseCase.getMyCity())
                            } else {
                                _myCitiesState.value = MyCitiesState.Error(result.message)
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("e", e.message.toString())
            }
        }
    }

    private fun checkSearchFieldValue(): Boolean {
        return searchFieldValue.isNotEmpty()
    }

    fun updateSearchField(input: String) {
        searchFieldValue = input
    }

    private fun isMyCitiesExist(): Boolean {
        return getMyCityUseCase.getMyCity().isNotEmpty()
    }
}