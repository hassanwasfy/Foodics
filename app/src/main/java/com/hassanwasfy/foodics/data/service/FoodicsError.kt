package com.hassanwasfy.foodics.data.service

sealed class FoodicsError(msg: String) : Exception(msg) {
    data object ServerError : FoodicsError("Server encountered an unexpected error.")
    data class ClientError(val details: String) : FoodicsError("Client error occurred: $details")
    data object NetworkError : FoodicsError("No internet connection or network issue.")
    data class UnexpectedError(val msg: String) : FoodicsError("An unexpected error occurred.: $msg")
}
