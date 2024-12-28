package com.hassanwasfy.foodics.ui.screens.products

import com.hassanwasfy.foodics.data.repository.ProductsRepository
import com.hassanwasfy.foodics.ui.base.BaseViewModel
import com.hassanwasfy.foodics.ui.models.domain.Product
import com.hassanwasfy.foodics.ui.models.toUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import java.text.DecimalFormat

class ProductsViewModel(private val repository: ProductsRepository) :
    BaseViewModel<ProductsUiState, ProductsUiEffect>(ProductsUiState()), ProductsInterActions {


    init {
        tryToExecute(
            execute = { repository.getProducts() },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    private suspend fun onSuccess(data: Flow<List<Product>>) {
        data.collect { dataList ->
            val uiList = dataList.map { it.toUiModel() }
            val categories = dataList.map { it.category }.distinctBy { it.id }
            _state.update {
                it.copy(
                    isLoading = false,
                    productsList = uiList,
                    categoryList = categories
                )
            }
        }
    }

    private fun onError(msg: String) {

    }

    override fun onBackClick() {

    }

    override fun onSearchQuery(query: String) {
        _state.update { currentState ->
            currentState.copy(
                searchValue = query,
                filteredList = if (query.isEmpty()) {
                    emptyList()
                } else {
                    currentState.productsList.filter { product ->
                        product.name.contains(query, ignoreCase = true)
                    }
                },
                currentCategory = if (query.isEmpty()) {
                    "0"
                } else {
                    currentState.currentCategory
                }
            )
        }

    }

    override fun onCategoryClick(categoryId: String) {
        _state.update { currentState ->
            currentState.copy(
                currentCategory = categoryId,
                filteredList = currentState.productsList.filter { product ->
                    product.categoryId == categoryId
                }
            )
        }
    }


    override fun onCLickProduct(productId: String) {
        val updatedProductsList = state.value.productsList.map { product ->
            if (product.id == productId) {
                product.copy(count = product.count + 1)
            } else {
                product
            }
        }

        val updatedFilteredList = if (state.value.filteredList.isNotEmpty()) {
            state.value.filteredList.map { product ->
                if (product.id == productId) {
                    product.copy(count = product.count + 1)
                } else {
                    product
                }
            }
        } else {
            emptyList()
        }

        val updatedOrderList = state.value.orderList.toMutableList().apply {
            val orderItem = find { it.id == productId }
            if (orderItem != null) {
                remove(orderItem)
                add(orderItem.copy(count = orderItem.count + 1))
            } else {
                val product = state.value.productsList.find { it.id == productId }
                product?.let { add(it.copy(count = 1)) }
            }
        }

        val totalAmount = updatedOrderList.sumOf { item -> item.count * item.price }

        val decimalFormat = DecimalFormat("#.##")
        val formattedAmount = decimalFormat.format(totalAmount).toDouble()

        _state.update { currentState ->
            currentState.copy(
                productsList = updatedProductsList,
                orderList = updatedOrderList,
                totalAmount = formattedAmount,
                filteredList = updatedFilteredList
            )
        }
    }


    override fun onClickViewOrder() {
        _state.update {
            it.copy(
                searchValue = "",
                orderList = emptyList(),
                filteredList = emptyList(),
                currentCategory = "0",
                totalAmount = 0.0,
                productsList = it.productsList.map { p -> p.copy(count = 0) }
            )
        }
    }


}