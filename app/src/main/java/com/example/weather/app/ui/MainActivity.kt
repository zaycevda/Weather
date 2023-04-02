package com.example.weather.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weather.app.di.App
import com.example.weather.app.ui.home.HomeScreen
import com.example.weather.app.ui.theme.WeatherTheme
import com.example.weather.app.utils.fromKelvinToCelsius
import com.example.weather.app.viewmodels.WeatherViewModel
import com.example.weather.app.viewmodels.WeatherViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var weatherViewModelFactory: WeatherViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject()

        setContent {
            WeatherTheme {

                val viewModel = viewModel<WeatherViewModel>(factory = weatherViewModelFactory)


                val flowCoordinates by viewModel.coordinates.collectAsState()

                val flowLat by lazy { flowCoordinates?.lat ?: 55.750446F }
                val flowLon by lazy { flowCoordinates?.lon ?: 37.617493F }

                viewModel.getCurrentWeather(
                    lat = flowLat,
                    lon = flowLon
                )
                val flowCurrentWeather by viewModel.currentWeather.collectAsState()
                val city by lazy { flowCurrentWeather?.name ?: "" }
                val currentTemp by lazy { flowCurrentWeather?.currentMainData?.temp?.fromKelvinToCelsius() ?: 0 }
                val description by lazy { flowCurrentWeather?.currentWeatherData?.get(0)?.description ?: "" }
                val feelsLike by lazy { flowCurrentWeather?.currentMainData?.feelsLike?.fromKelvinToCelsius() ?: 0 }
                val windSpeed by lazy { flowCurrentWeather?.wind?.speed ?: 0.0 }
                val humidity by lazy { flowCurrentWeather?.currentMainData?.humidity ?: 0 }
                val pressure by lazy { flowCurrentWeather?.currentMainData?.pressure ?: 0 }

                viewModel.getForecastWeather(
                    lat = flowLat,
                    lon = flowLon
                )
                val flowForecastWeather by viewModel.forecastWeather.collectAsState()
                val listData by lazy { flowForecastWeather?.list ?: listOf() }

                val search = { name: String -> viewModel.getCoordinates(city = name) }

                val flowLoadingProgressBar by viewModel.loading.collectAsState()
                val loadingProgressBar by lazy { flowLoadingProgressBar }

                HomeScreen(
                    search = search,
                    loadingProgressBar = loadingProgressBar,
                    city = city,
                    currentTemp = currentTemp,
                    description = description,
                    feelsLike = feelsLike,
                    windSpeed = windSpeed,
                    humidity = humidity,
                    pressure = pressure,
                    listData = listData
                )
            }
        }
    }

    private fun inject() {
        (applicationContext as App).appComponent.injectMainScreen(activity = this)
    }
}