package com.composeweatherapp.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.composeweatherapp.R
import com.composeweatherapp.core.component.CurrentWeatherDetailRow
import com.composeweatherapp.core.component.ForecastLazyRow
import com.composeweatherapp.core.component.ForecastTitle

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        BackgroundImage()
        MenuIcon()
        CurrentWeatherInfoSection()
        DetailsSection()
    }
}

@Composable
private fun BackgroundImage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun CurrentWeatherInfoSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = 72.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Montreal", style = MaterialTheme.typography.h2)
        Text(text = "19°", style = MaterialTheme.typography.h1)
        Text(text = "Mostly Clear", style = MaterialTheme.typography.h3, color = Color.Gray)
        Text(text = "H:24°  L:18°", style = MaterialTheme.typography.h3)
    }
}

@Composable
private fun MenuIcon() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = 24.dp, end = 24.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        IconButton(modifier = Modifier
            .size(24.dp),
            onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
private fun DetailsSection() {
    Box(
        modifier = Modifier.fillMaxSize(),
        Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(LocalConfiguration.current.screenHeightDp.dp / 2),
            backgroundColor = MaterialTheme.colors.onSurface,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                ForecastSection()
                WeatherDetailSection()
            }
        }
    }
}

@Composable
private fun ForecastSection() {
    ForecastTitle(text = "Hourly Forecast")
    ForecastLazyRow(items = 8)
    ForecastTitle(text = "Weekly Forecast")
    ForecastLazyRow(items = 7)
}

@Composable
private fun WeatherDetailSection() {
    CurrentWeatherDetailRow(
        title1 = "🌡 TEMP",
        value1 = "19",
        title2 = "🌡 FEELS LIKE",
        value2 = "19"
    )
    CurrentWeatherDetailRow(
        title1 = "☁ CLOUDINESS",
        value1 = "100%",
        title2 = "💧 HUMIDITY",
        value2 = "90%"
    )
    CurrentWeatherDetailRow(
        title1 = "🌇 SUNRISE",
        value1 = "06:00",
        title2 = "🌆 SUNSET",
        value2 = "19:00"
    )
    CurrentWeatherDetailRow(
        title1 = "🌬 WIND",
        value1 = "16KM",
        title2 = "⏲ PRESSURE",
        value2 = "1015"
    )
}