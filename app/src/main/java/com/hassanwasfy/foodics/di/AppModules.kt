package com.hassanwasfy.foodics.di

import androidx.room.Room
import com.hassanwasfy.foodics.data.local.database.AppDatabase
import com.hassanwasfy.foodics.data.repository.ProductsRepository
import com.hassanwasfy.foodics.data.service.ApiService
import com.hassanwasfy.foodics.ui.screens.products.ProductsViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val appModule = module {

    single {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true; isLenient = true })
            }

            install(Logging) {
                level = LogLevel.BODY
            }
        }
    }

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "app_database")
            .build()
    }
    single { get<AppDatabase>().productDao() }

    single { ApiService(get()) }

    single { ProductsRepository(get(), get()) }

    single { ProductsViewModel(get()) }
}