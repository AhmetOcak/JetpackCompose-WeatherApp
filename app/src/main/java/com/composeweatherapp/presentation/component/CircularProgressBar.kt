package com.composeweatherapp.presentation.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun CircularProgressBar() {
    CircularProgressIndicator(
        modifier = Modifier.size(LocalConfiguration.current.screenWidthDp.dp / 3),
        color = MaterialTheme.colors.secondaryVariant,
        strokeWidth = 5.dp
    )
}