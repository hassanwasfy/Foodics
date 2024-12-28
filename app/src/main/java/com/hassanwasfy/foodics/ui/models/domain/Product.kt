package com.hassanwasfy.foodics.ui.models.domain

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val price: Double,
    val category: Category
)
