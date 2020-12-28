package com.example.kotlinstudy.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlinstudy.data.repository.Repository
import com.example.kotlinstudy.data.response.WeatherResponse
import com.example.kotlinstudy.ui.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
) : BaseViewModel() {

    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse>
        get() = _weatherData

    private val _dataLoading = MutableLiveData(false)
    val dataLoading: LiveData<Boolean>
        get() = _dataLoading

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: MutableLiveData<String>
        get() = _errorMsg

    private var job: Job ?= null

    init {
        getWeatherData(126.98, 37.57)
    }

    fun getWeatherData(lon: Double,
                   lat: Double) {

        job?.cancel()
        job = viewModelScope.launch {
            _dataLoading.value = true

            repository.getWeatherData(lon, lat)
                    .catch { e ->
                        _errorMsg.value = e.toString()
                    }
                .collect {
                    _weatherData.value = it
                }
            _dataLoading.value = false
        }
    }
}