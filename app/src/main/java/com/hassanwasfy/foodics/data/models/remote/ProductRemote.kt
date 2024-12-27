package com.hassanwasfy.foodics.data.models.remote

import kotlinx.serialization.Serializable

@Serializable
data class ProductRemote(
    val id: String,
    val name: String,
    val category_id: String,
    val category_name: String,
    val description: String,
    val image: String,
    val price: String
)



