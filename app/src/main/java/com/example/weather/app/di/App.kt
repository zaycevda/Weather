package com.example.weather.app.di

import android.app.Application

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()
    }
}