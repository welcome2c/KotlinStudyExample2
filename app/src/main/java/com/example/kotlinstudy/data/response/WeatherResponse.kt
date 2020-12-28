package com.example.kotlinstudy.data.response

import dhkim.project.smallsafety.main.model.weatherModel.*

data class WeatherResponse (
    var coord: Coord,
    var weather: List<Weather>,
    var base: String,
    var main: Main,
    var visibility: Double,
    var wind: Wind,
    var clouds: Clouds,
    var dt: Double,
    var sys: Sys,
    var timezone: Double,
    var id: Double,
    var name: String,
    var cod: Double
)