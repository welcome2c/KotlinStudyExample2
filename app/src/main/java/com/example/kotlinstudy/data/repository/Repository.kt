package com.example.kotlinstudy.data.repository

import com.example.kotlinstudy.data.response.WeatherResponse
import kotlinx.coroutines.flow.Flow


interface Repository {
    fun getWeatherData(
        lon: Double,
        lat: Double
    ): Flow<WeatherResponse>
}