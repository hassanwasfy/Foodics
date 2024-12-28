package com.hassanwasfy.foodics.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Embedded

@Entity
data class ProductEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val image: String,
    val price: Double,
    @Embedded val category: CategoryEntity
)
