package com.hassanwasfy.foodics.ui.screens.products

import com.hassanwasfy.foodics.ui.base.BaseUiState
import com.hassanwasfy.foodics.ui.base.ErrorUiState
import com.hassanwasfy.foodics.ui.models.domain.Category
import com.hassanwasfy.foodics.ui.models.ui.ProductUi

data class ProductsUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState = ErrorUiState(),
    val userName: String = "Hassan Wasfy",
    val userNumber: String = "991253",
    val tableNumber: String = "03",
    val peopleCount: String = "02",
    val searchValue: String = "",
    val currentCategory: String = "0",
    val categoryList: List<Category> = emptyList(),
    val productsList: List<ProductUi> = emptyList(),
    val filteredList: List<ProductUi> = emptyList(),
    val orderList: List<ProductUi> = emptyList(),
    val totalAmount: Double = 0.0
) : BaseUiState
