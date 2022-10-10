package com.composeweatherapp.presentation.navigation

sealed class NavScreen(val route: String) {
    object HomeScreen : NavScreen(NavRoutes.homeScreen)
    object SearchCityScreen : NavScreen(NavRoutes.searchCityScreen)
}
