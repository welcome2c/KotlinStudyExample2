package com.example.kotlinstudy.data.repository

import com.example.kotlinstudy.data.WeatherApi
import com.example.kotlinstudy.data.response.WeatherResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(
        private val weatherApi: WeatherApi
        ): Repository {
    override fun getWeatherData(
        lon: Double,
        lat: Double)
        : Flow<WeatherResponse> {
        return flow {
            val result = weatherApi.getWeather(lon.toString(), lat.toString(), "d491a1413031f86fa09c4ef5e219c56b")
            emit(result)
        }
    }

}