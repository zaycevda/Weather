package com.example.weather.app.storage

import android.app.Activity
import android.content.Context
import com.example.weather.data.utils.showLog

class SharedPreference(activity: Activity) {

    private val prefs = activity.getSharedPreferences(
        "last city",
        Context.MODE_PRIVATE
    )
    private val city = prefs.getString("city", "Moscow")
    private val editor = prefs.edit()

    fun newCity(city: String) {
        showLog("put prefs: ${prefs.all}")
        editor.putString(
            "city",
            city
        )
        editor.apply()
    }

    fun getCity(): String? {
        showLog("get prefs: ${prefs.all}")
        return city
    }
}