package com.hassanwasfy.foodics.data.local.dao

import androidx.room.*
import com.hassanwasfy.foodics.data.models.local.CategoryEntity
import com.hassanwasfy.foodics.data.models.local.ProductEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductsDao {
    @Transaction
    @Query("SELECT * FROM ProductEntity")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoryEntity>)
}