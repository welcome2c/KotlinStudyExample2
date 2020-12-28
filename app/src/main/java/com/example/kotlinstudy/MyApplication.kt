package com.example.kotlinstudy

import android.app.Application
import com.example.kotlinstudy.data.di.repositoryModule
import com.example.kotlinstudy.data.di.viewModelModule
import com.example.kotlinstudy.data.di.weatherApiModule
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                    listOf(
                    weatherApiModule,
                    repositoryModule,
                    viewModelModule
            ))
        }
    }
}