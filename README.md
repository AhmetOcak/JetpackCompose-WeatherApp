# Jetpack Compose WeatherApp 🌡

WeatherApp is an application that shows you the weather according to your location. You can find out by searching the weather information of the city you want. You can save the weather of the city you want. If you have an internet connection, the weather conditions of these cities are updated automatically. Weather information is saved on the device.

<br/>

You can enter your API key in the location specified in the Constants.kt file in the utilites folder.

<p align="left" width="100%">
  <img src="https://user-images.githubusercontent.com/73544434/195295033-ebffb332-ca01-412b-bc01-f1bd25526567.PNG"/>
</p>


## Api 
* [OpenWeather Call 5 day / 3 hour forecast data](https://openweathermap.org/forecast5)

## Libraries 📚

* [Navigation](https://developer.android.com/jetpack/compose/navigation)

* [Retrofit](https://square.github.io/retrofit)

* [Location](https://developer.android.com/training/location)

* [ViewModel](https://developer.android.com/jetpack/compose/libraries#viewmodel)

* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

* [Room](https://developer.android.com/jetpack/androidx/releases/room)

* [Accompanist](https://google.github.io/accompanist/insets/)

## Assets 📦

* [Weather Icons](https://designdkblog.blogspot.com/2021/05/get-3d-weather-icons-for-adobe-xd-figma.html)
* <a href="https://www.flaticon.com/free-icons/error" title="error icons">Error icons created by Freepik - Flaticon</a>

## Outputs 🖼

### Home Screen 🏠

<p align="left" width="100%">

 <img src="https://media.giphy.com/media/0S5RLp4fz72MunYvd6/giphy.gif" width="240" height="480"/>
  
</p>

### Search City Screen 🔍

<p align="left" width="100%">

 <img src="https://media.giphy.com/media/aTKODI1K4knzOCnhFx/giphy.gif" width="240" height="480"/>
 
 <img src="https://media.giphy.com/media/8EsdaR9oKcl9mwIusL/giphy.gif" width="240" height="480"/>
  
</p>

### Error Screens ⚠

<p align="left" width="100%">

<img src="https://user-images.githubusercontent.com/73544434/195306299-49f2a625-fac9-4dd3-b612-43f450edf2f8.png" width="240" height="480"/>
<img src="https://user-images.githubusercontent.com/73544434/195306115-a9416fc0-f708-46d6-95b2-57937f7ef75a.png" width="240" height="480"/>
<img src="https://user-images.githubusercontent.com/73544434/195306207-ece817c1-afe9-4d7a-8509-856912c3c24a.png" width="240" height="480"/>
<img src="https://user-images.githubusercontent.com/73544434/195306292-53c35d32-d5c3-4eea-be5d-2c0b93dd30a0.png" width="240" height="480"/>
  
</p>

## Project Structure 🏗

```
...
composeweatherapp
│
|
└───app
|   |   WeatherApplication.kt
|   |
|   └───theme
|   |   |
|   |   |   Color.kt
|   |   |   Shape.kt
|   |   |   Theme.kt
|   |   |   Type.kt
|
└───core
|   |
|   └───di
|   |   |   AppModule
|   |   |   DaoModule
|   |   |   LocationModule
|   |   |   RepositoryModule
|   |   |   RoomModule
|   |   
|   └───helpers
|   |   |   EpochConverter
|   |   |   HourConverter
|   |   |   SetError
|   
└───data
|   |
|   └───datasource
|   |   |
|   |   └───local
|   |   |   |   CityLocalDataSource
|   |   |   |   ForecastLocalDataSource
|   |   |   |   MyCityLocalDataSource
|   |   |   |
|   |   |   └───db
|   |   |   |   |
|   |   |   |   └───entity
|   |   |   |   |   |   CityEntity
|   |   |   |   |   |   ForecastEntity
|   |   |   |   |   |   MyCityEntity
|   |   |   |   |
|   |   |   |   └───room
|   |   |   |   |   |   CityDao
|   |   |   |   |   |   ForecastDao
|   |   |   |   |   |   MyCityDao
|   |   |   |   |   |   WeatherDatabase
|   |   |
|   |   └───remote
|   |   |   |   ForecastRemoteDataSource
|   |   |   |
|   |   |   └───entity
|   |   |   |   |   |   CityDto
|   |   |   |   |   |   CloudinessDto
|   |   |   |   |   |   CloudsDto
|   |   |   |   |   |   CoordDto
|   |   |   |   |   |   ForecastDto
|   |   |   |   |   |   ForecastWeatherDto
|   |   |   |   |   |   MainDto
|   |   |   |   |   |   SysDto
|   |   |   |   |   |   WeatherDto
|   |   |   |   |   |   WindDto
|   |   |   |
|   |   |   └───weatherapi
|   |   |   |   |   WeatherApi
|   |
|   └───location
|   |   |   DefaultLocationTracker
|   |
|   └───mapper
|   |   |   CityDtoMapper
|   |   |   CityEntityMappper
|   |   |   ForecastDtoMapper
|   |   |   ForecastEntityMapper
|   |   |   MyCityEntityMapper
|   |
|   └───repository
|   |   |   ForecastRepositoryImpl
|   |   |   MyCityRepositoryImpl
|
└───domain
|   |
|   └───location
|   |   |   LocationTracker
|   |
|   └───mapper
|   |   |   IEntityMapper
|   |
|   └───model
|   |   |   City
|   |   |   Cloudiness
|   |   |   Clouds
|   |   |   Coord
|   |   |   Forecast
|   |   |   ForecastWeather
|   |   |   Main
|   |   |   MyCity
|   |   |   Sys
|   |   |   Weather
|   |   |   Wind
|   |
|   └───repository
|   |   |   ForecastRepository
|   |   |   MyCityRepository
|   |
|   └───usecase
|   |   |
|   |   └───forecast
|   |   |   |   AddCityToDbUseCase
|   |   |   |   AddForecastToDbUseCase
|   |   |   |   GetCityFromDbUseCase
|   |   |   |   GetForecastFromDbUseCase
|   |   |   |   GetForecastUseCase
|   |   |   |   GetForecastWithCityNameUseCase
|   |   |   |   UpdateCityDbUseCase
|   |   |   |   UpdateForecastDbUseCase
|   |   |
|   |   └───location
|   |   |   |   GetLocationUseCase
|   |   |
|   |   └───my_city
|   |   |   |   AddMyCityUseCase
|   |   |   |   DeleteMyCityUseCase
|   |   |   |   GetMyCityUseCase
|   |   |   |   GetSpecificCityUseCase
|   |   |   |   UpdateMyCityUseCase
|   |
|   └───util
|   |   |   Resource
|
└───presentation
|   |
|   └───component
|   |   |   CircularProgressBar.kt
|   |   |   CityWeatherCard.kt
|   |   |   CurrentWeatherDetailRow.kt
|   |   |   ErrorCard.kt
|   |   |   ForecastLazyRow.kt
|   |   |   ForecastTitle
|   |
|   └───home
|   |   |   HomeForecastState
|   |   |   HomeScreen.kt
|   |   |   HomeViewModel
|   |
|   └───main
|   |   |   MainActivity
|   |
|   └───navigation
|   |   |   NavGraph.kt
|   |   |   NavRoutes
|   |   |   NavScreen
|   |
|   └───search
|   |   |   MyCitiesState
|   |   |   SearchCityScreen.kt
|   |   |   SearchCityState
|   |   |   SearchCityViewModel
|
└───utils
|   |   Constants
|   |   WeatherType

```

