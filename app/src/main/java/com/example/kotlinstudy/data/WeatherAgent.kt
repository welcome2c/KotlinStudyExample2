package com.example.kotlinstudy.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherAgent {
    val retrofit: WeatherApi = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)
}