package com.example.kotlinstudy.data

import com.example.kotlinstudy.data.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather?")
    suspend fun getWeather(
        @Query("lon") lon: String?,
        @Query("lat") lat: String?,
        @Query("appid") appKey: String?
    ): WeatherResponse
}