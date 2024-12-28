package com.hassanwasfy.foodics.ui.models.ui

data class ProductUi(
    val id: String,
    val categoryId: String,
    val name: String,
    val image: String,
    val count: Int,
    val desc: String,
    val price: Double
)
