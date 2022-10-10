package com.composeweatherapp.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CurrentWeatherDetailRow(title1: String, value1: String, title2: String, value2: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CurrentWeatherDetailCard(title = title1, value = value1)
        CurrentWeatherDetailCard(title = title2, value = value2)
    }
}

@Composable
private fun CurrentWeatherDetailCard(title: String, value: String) {
    Card(
        modifier = Modifier.size(180.dp),
        backgroundColor = MaterialTheme.colors.onSecondary,
        shape = MaterialTheme.shapes.small,
        border = null
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(start = 8.dp, top = 8.dp), Alignment.TopStart) {
            Text(text = title, style = MaterialTheme.typography.h3.copy(fontSize = 18.sp))
        }
        Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
            Text(
                text = value,
                style = MaterialTheme.typography.h2.copy(fontSize = 36.sp)
            )
        }
    }
}