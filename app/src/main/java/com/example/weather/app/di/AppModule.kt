package com.example.weather.app.di

import android.content.Context
import com.example.weather.app.viewmodels.WeatherViewModelFactory
import com.example.weather.domain.usecases.GetCoordinatesUseCase
import com.example.weather.domain.usecases.GetCurrentWeatherUseCase
import com.example.weather.domain.usecases.GetForecastWeatherUseCase
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    fun provideWeatherViewModelFactory(
        getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
        getForecastWeatherUseCase: GetForecastWeatherUseCase,
        getCoordinatesUseCase: GetCoordinatesUseCase
    ) = WeatherViewModelFactory(
        getCurrentWeatherUseCase = getCurrentWeatherUseCase,
        getForecastWeatherUseCase = getForecastWeatherUseCase,
        getCoordinatesUseCase = getCoordinatesUseCase
    )
}