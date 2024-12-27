package com.hassanwasfy.foodics

import android.app.Application
import com.hassanwasfy.foodics.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class FoodicsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FoodicsApplication)
            modules(appModule)
        }
    }
}