package com.example.weather.app.di

import com.example.weather.app.ui.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    fun injectMainScreen(activity: MainActivity)
}