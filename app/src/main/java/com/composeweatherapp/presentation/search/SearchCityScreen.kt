package com.composeweatherapp.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeweatherapp.R
import com.composeweatherapp.app.theme.Blue
import com.composeweatherapp.app.theme.DarkBlue
import com.composeweatherapp.app.theme.LightBlue
import com.composeweatherapp.core.component.CityWeatherCard

@Composable
fun SearchCityScreen() {
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
        topBar = { TopBarSection() },
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
private fun TopBarSection() {
    TopAppBar(
        modifier = Modifier.statusBarsPadding(),
        title = { Text(text = "Weather", style = MaterialTheme.typography.h2) },
        navigationIcon = {
            IconButton(onClick = {}) {
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
        placeholder = { Text(text = "Search for a city") },
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
                degree = "19",
                coordinates = listOf("23", "12"),
                city = "Montreal",
                country = "Canada",
                description = "Mid Rain",
                weatherImage = R.drawable.cloud_zap
            )
        }
    }
}