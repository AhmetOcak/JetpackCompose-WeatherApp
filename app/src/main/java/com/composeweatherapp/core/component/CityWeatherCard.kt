package com.composeweatherapp.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeweatherapp.app.theme.DarkBlue

@Composable
fun CityWeatherCard(
    degree: String,
    coordinates: List<String>,
    city: String,
    country: String,
    description: String,
    weatherImage: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp / 4)
            .padding(top = 16.dp),
        backgroundColor = DarkBlue,
        shape = MaterialTheme.shapes.medium
    ) {
        WeatherImage(weatherImage = weatherImage)
        WeatherInfo(degree, coordinates, city, country, description)
    }
}

@Composable
private fun WeatherImage(weatherImage: Int) {
    Box(modifier = Modifier.fillMaxSize(), Alignment.CenterEnd) {
        Image(
            modifier = Modifier.size(LocalConfiguration.current.screenWidthDp.dp / 2),
            painter = painterResource(id = weatherImage),
            contentDescription = null
        )
    }
}

@Composable
private fun WeatherInfo(
    degree: String,
    coordinates: List<String>,
    city: String,
    country: String,
    description: String,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Degree(degree)
        LocationAndDescription(coordinates, city, country, description)
    }
}

@Composable
private fun Degree(degree: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = degree, fontSize = 76.sp)
    }
}

@Composable
private fun LocationAndDescription(
    coordinates: List<String>,
    city: String,
    country: String,
    description: String,
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "H:${coordinates[0]}  L:${coordinates[1]}")
            Text(text = "${city}, $country")
        }
        Text(text = description)
    }
}