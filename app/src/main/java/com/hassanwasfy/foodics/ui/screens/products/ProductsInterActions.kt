package com.hassanwasfy.foodics.ui.screens.products

interface ProductsInterActions {
    fun onBackClick()
    fun onSearchQuery(query: String)
    fun onCategoryClick(categoryId: String)
    fun onCLickProduct(productId: String)
    fun onClickViewOrder()
}