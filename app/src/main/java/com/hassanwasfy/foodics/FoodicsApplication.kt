package com.hassanwasfy.foodics

import android.app.Application
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.hassanwasfy.foodics.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class FoodicsApplication: Application(),SingletonImageLoader.Factory  {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FoodicsApplication)
            modules(appModule)
        }
    }

    override fun newImageLoader(context: PlatformContext): ImageLoader {
        return ImageLoader.Builder(this)
            .crossfade(true)
            .logger(DebugLogger())
            .build()
    }

}