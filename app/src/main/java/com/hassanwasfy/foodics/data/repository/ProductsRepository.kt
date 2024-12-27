package com.hassanwasfy.foodics.data.repository

import com.hassanwasfy.foodics.data.local.dao.ProductsDao
import com.hassanwasfy.foodics.data.local.mapper.toDomainModel
import com.hassanwasfy.foodics.data.local.mapper.toProductEntity
import com.hassanwasfy.foodics.data.models.local.CategoryEntity
import com.hassanwasfy.foodics.data.service.ApiService
import com.hassanwasfy.foodics.ui.models.domain.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class ProductsRepository(
    private val apiService: ApiService,
    private val productsDao: ProductsDao
) {

    fun getProducts(): Flow<List<Product>> = flow {
        val localProducts = productsDao.getAllProducts().first()
        if (localProducts.isNotEmpty()) {
            emit(localProducts.map { it.toDomainModel() })
        } else {
            val apiResult = apiService.fetchProducts()
            apiResult.fold(
                onSuccess = { remoteProducts ->
                    val categories =
                        remoteProducts.map { CategoryEntity(it.category_id, it.category_name) }
                            .distinct()
                    val products = remoteProducts.map { it.toProductEntity() }
                    productsDao.insertCategories(categories)
                    productsDao.insertProducts(products)
                    emit(products.map { it.toDomainModel() })
                },
                onFailure = { throw it }
            )
        }
    }
}