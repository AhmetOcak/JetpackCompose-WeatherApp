package com.composeweatherapp.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.composeweatherapp.R
import com.composeweatherapp.app.theme.Blue
import com.composeweatherapp.app.theme.DarkBlue
import com.composeweatherapp.app.theme.LightBlue
import com.composeweatherapp.presentation.component.CityWeatherCard
import com.composeweatherapp.utils.AppStrings

@Composable
fun SearchCityScreen(onNavigateToHomeScreen: () -> Unit) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        DarkBlue,
                        Blue,
                        LightBlue,
                    )
                )
            ),
        topBar = { TopBarSection(onNavigateToHomeScreen) },
        backgroundColor = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            SearchField()
            CityWeatherList()
        }
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
private fun SearchField() {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = {},
        placeholder = { Text(text = AppStrings.placeholder) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = null
            )
        }
    )
}

@Composable
private fun CityWeatherList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(7) {
            CityWeatherCard(
                degree = "19${AppStrings.degree}",
                coordinates = listOf("23", "12"),
                city = "Montreal",
                country = "Canada",
                description = "Mid Rain",
                weatherImage = R.drawable.rain_day
            )
        }
    }
}