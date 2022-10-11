package com.composeweatherapp.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.composeweatherapp.R
import com.composeweatherapp.app.theme.Blue
import com.composeweatherapp.app.theme.DarkBlue
import com.composeweatherapp.app.theme.LightBlue
import com.composeweatherapp.core.helpers.HourConverter
import com.composeweatherapp.domain.model.Forecast
import com.composeweatherapp.domain.model.MyCity
import com.composeweatherapp.presentation.component.CircularProgressBar
import com.composeweatherapp.presentation.component.CityWeatherCard
import com.composeweatherapp.presentation.component.ErrorCard
import com.composeweatherapp.utils.*

@Composable
fun SearchCityScreen(viewModel: SearchCityViewModel, onNavigateToHomeScreen: () -> Unit) {
    val searchCityState by viewModel.searchCityState.collectAsState()
    val myCitiesState by viewModel.myCitiesState.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(DarkBlue, Blue, LightBlue))),
        topBar = { TopBarSection(onNavigateToHomeScreen) },
        backgroundColor = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            SearchCityScreenContent(
                viewModel = viewModel,
                searchCityState = searchCityState,
                myCitiesState = myCitiesState
            )
        }
    }
}

@Composable
private fun SearchCityScreenContent(
    viewModel: SearchCityViewModel,
    searchCityState: SearchCityState,
    myCitiesState: MyCitiesState
) {
    SearchField(viewModel)
    if (viewModel.isCitySearched) {
        when (searchCityState) {
            is SearchCityState.Loading -> {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressBar(
                        modifier = Modifier
                            .size(LocalConfiguration.current.screenWidthDp.dp / 3)
                            .padding(top = 16.dp),
                    )
                }
            }
            is SearchCityState.Success -> {
                if (searchCityState.forecast != null) {
                    WantedCityWeatherSection(searchCityState.forecast, viewModel)
                }
            }
            is SearchCityState.Error -> {
                SearchResultErrorMessage(searchCityState.errorMessage, viewModel)
            }
        }
        MyCities(myCitiesState, viewModel)
    } else {
        MyCities(myCitiesState, viewModel)
    }
}

@Composable
private fun TopBarSection(onBackClick: () -> Unit) {
    TopAppBar(
        modifier = Modifier.statusBarsPadding(),
        title = { Text(text = AppStrings.topbar_title, style = MaterialTheme.typography.h2) },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}

@Composable
private fun SearchField(viewModel: SearchCityViewModel) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = viewModel.searchFieldValue,
        onValueChange = { viewModel.updateSearchField(it) },
        label = {
            Text(text = AppStrings.placeholder)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        maxLines = 1,
        trailingIcon = {
            IconButton(onClick = { viewModel.searchCityClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun WantedCityWeatherSection(forecast: Forecast, viewModel: SearchCityViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text(text = AppStrings.subtitle2, style = MaterialTheme.typography.h2)
        CityWeatherCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(LocalConfiguration.current.screenHeightDp.dp / 4)
                .padding(top = 16.dp),
            degree = "${forecast.weatherList[0].weatherData.temp.toInt()}${AppStrings.degree}",
            latitude = forecast.cityDtoData.coordinate.latitude,
            longitude = forecast.cityDtoData.coordinate.longitude,
            city = forecast.cityDtoData.cityName,
            country = forecast.cityDtoData.country,
            description = forecast.weatherList[0].weatherStatus[0].description,
            weatherImage = WeatherType.setWeatherType(
                forecast.weatherList[0].weatherStatus[0].mainDescription,
                forecast.weatherList[0].weatherStatus[0].description,
                HourConverter.convertHour(forecast.weatherList[0].date.substring(11, 13)),
            ),
            isItDb = false,
            onClick = {
                viewModel.addMyCity(
                    MyCity(
                        temp = forecast.weatherList[0].weatherData.temp,
                        latitude = forecast.cityDtoData.coordinate.latitude,
                        longitude = forecast.cityDtoData.coordinate.longitude,
                        cityName = forecast.cityDtoData.cityName,
                        country = forecast.cityDtoData.country,
                        description = forecast.weatherList[0].weatherStatus[0].description,
                        weatherImage = WeatherType.setWeatherType(
                            forecast.weatherList[0].weatherStatus[0].mainDescription,
                            forecast.weatherList[0].weatherStatus[0].description,
                            HourConverter.convertHour(forecast.weatherList[0].date.substring(11, 13)),
                        ),
                    )
                )
            }
        )
    }
}

@Composable
private fun MyCities(myCitiesState: MyCitiesState, viewModel: SearchCityViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        horizontalAlignment = Alignment.Start
    ) {
        when (myCitiesState) {
            is MyCitiesState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressBar(modifier = Modifier.size(LocalConfiguration.current.screenWidthDp.dp / 3))
                }
            }
            is MyCitiesState.Success -> {
                if (myCitiesState.forecast.isNullOrEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        EmptyCityListMessage()
                    }
                } else {
                    CityListSection(myCitiesState.forecast, viewModel)
                }
            }
            is MyCitiesState.Error -> {
                CityListErrorMessage(myCitiesState.errorMessage)
            }
        }
    }
}

@Composable
private fun SearchResultErrorMessage(errorMessage: String?, viewModel: SearchCityViewModel) {
    ErrorCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        errorTitle = AppStrings.error_title,
        errorDescription = errorMessage ?: Constants.UNKNOWN_ERROR,
        errorButtonText = ErrorCardConsts.BUTTON_TEXT,
        onClick = { viewModel.errorOnClick() },
        cardModifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp / 4 + 48.dp)
    )
}

@Composable
private fun EmptyCityListMessage() {
    Image(
        modifier = Modifier
            .size(128.dp)
            .padding(bottom = 16.dp),
        painter = painterResource(id = R.drawable.no_city),
        contentDescription = null
    )
    Text(text = AppStrings.no_city)
}

@Composable
private fun CityListSection(cityList: List<MyCity>, viewModel: SearchCityViewModel) {
    Text(
        text = AppStrings.subtitle1,
        style = MaterialTheme.typography.h2
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(cityList) {
            CityWeatherCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(LocalConfiguration.current.screenHeightDp.dp / 4)
                    .padding(top = 16.dp),
                degree = "${it.temp.toInt()}${AppStrings.degree}",
                latitude = it.latitude,
                longitude = it.longitude,
                city = it.cityName,
                country = it.country,
                description = it.description,
                weatherImage = it.weatherImage,
                isItDb = true,
                onClick = { viewModel.removeMyCity(it.cityName) }
            )
        }
    }
}

@Composable
private fun CityListErrorMessage(errorMessage: String?) {
    ErrorCard(
        errorTitle = errorMessage ?: Constants.UNKNOWN_ERROR,
        errorDescription = errorMessage ?: Constants.UNKNOWN_ERROR,
        errorButtonText = ErrorCardConsts.BUTTON_TEXT,
        onClick = {},
        cardModifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp / 4 + 48.dp)
    )
}