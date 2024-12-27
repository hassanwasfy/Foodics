package com.hassanwasfy.foodics.data.service

import com.hassanwasfy.foodics.BuildConfig
import com.hassanwasfy.foodics.data.models.remote.ProductRemote
import com.hassanwasfy.foodics.data.service.ApiService.Endpoints.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException

class ApiService(private val client: HttpClient) {

    object Endpoints {
        const val BASE_URL = "https://fabricate.mockaroo.com/api/v1/databases/foodics/api"
        const val PRODUCTS = "/products"
        const val CATEGORIES = "/categories"
    }

    suspend fun fetchProducts(): Result<List<ProductRemote>> {
        return try {
            val response: List<ProductRemote> = client.get("$BASE_URL${Endpoints.PRODUCTS}") {
                header(HttpHeaders.Authorization, "Bearer ${BuildConfig.API_KEY}")
            }.body()
            Result.success(response)
        } catch (e: Exception) {
            handleError(e)
        }
    }


    private fun handleError(e: Exception): Result<Nothing> {
        return when (e) {
            is ClientRequestException -> Result.failure(FoodicsError.ClientError(e.response.status.value.toString()))
            is ServerResponseException -> Result.failure(FoodicsError.ServerError)
            is SerializationException -> Result.failure(FoodicsError.UnexpectedError(e.message.toString()))
            is IOException -> Result.failure(FoodicsError.NetworkError)
            else -> Result.failure(FoodicsError.UnexpectedError(e.message.toString()))
        }
    }
}

