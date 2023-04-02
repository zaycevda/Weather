package com.example.weather.app.di

import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.domain.usecases.GetCoordinatesUseCase
import com.example.weather.domain.usecases.GetCurrentWeatherUseCase
import com.example.weather.domain.usecases.GetForecastWeatherUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetCurrentWeatherUseCase(weatherRepository: WeatherRepository) =
        GetCurrentWeatherUseCase(weatherRepository = weatherRepository)

    @Provides
    fun provideGetForecastWeatherUseCase(weatherRepository: WeatherRepository) =
        GetForecastWeatherUseCase(weatherRepository = weatherRepository)

    @Provides
    fun provideGetCoordinatesUseCase(weatherRepository: WeatherRepository) =
        GetCoordinatesUseCase(weatherRepository = weatherRepository)
}