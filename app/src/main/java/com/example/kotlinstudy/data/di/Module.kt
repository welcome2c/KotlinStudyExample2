package com.example.kotlinstudy.data.di

import com.example.kotlinstudy.data.WeatherApi
import com.example.kotlinstudy.data.repository.Repository
import com.example.kotlinstudy.data.repository.RepositoryImpl
import com.example.kotlinstudy.ui.main.MainViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val TIME_OUT = 10L

val httpLoggingModule = module {
    single<Interceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}

val okHttpClientModule = module {
    single {
        OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(get<Interceptor>())
                .build()
    }
}

val weatherApiModule = module {
    single {
        Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(get<OkHttpClient>())
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