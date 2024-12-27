package com.hassanwasfy.foodics.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hassanwasfy.foodics.data.local.dao.ProductsDao
import com.hassanwasfy.foodics.data.models.local.CategoryEntity
import com.hassanwasfy.foodics.data.models.local.ProductEntity

@Database(entities = [ProductEntity::class, CategoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductsDao
}