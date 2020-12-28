package com.example.kotlinstudy.data.di

import com.example.kotlinstudy.data.WeatherApi
import com.example.kotlinstudy.data.repository.Repository
import com.example.kotlinstudy.data.repository.RepositoryImpl
import com.example.kotlinstudy.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherApiModule = module {
    single {
        Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApi::class.java)
    }
}

val repositoryModule = module {
    single <Repository> {
        RepositoryImpl(get())
    }
}

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}