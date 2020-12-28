package com.example.kotlinstudy

import android.app.Application
import com.example.kotlinstudy.data.di.*
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                    listOf(
                    httpLoggingModule,
                    okHttpClientModule,
                    weatherApiModule,
                    repositoryModule,
                    viewModelModule
            ))
        }
    }
}