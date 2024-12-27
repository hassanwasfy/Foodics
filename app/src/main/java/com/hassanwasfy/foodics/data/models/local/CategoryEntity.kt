package com.hassanwasfy.foodics.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey val categoryId: String,
    val categoryName: String
)
