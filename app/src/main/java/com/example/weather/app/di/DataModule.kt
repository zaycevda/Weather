package com.example.weather.app.di

import com.example.weather.data.repository.WeatherRepositoryImpl
import com.example.weather.data.service.WeatherApi
import com.example.weather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {

    @Provides
    fun provideWeatherApi(): WeatherApi =
        Retrofit.Builder()
            .baseUrl(WeatherApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)

    @Provides
    fun provideWeatherRepository(weatherApi: WeatherApi): WeatherRepository =
        WeatherRepositoryImpl(weatherApi = weatherApi)
}