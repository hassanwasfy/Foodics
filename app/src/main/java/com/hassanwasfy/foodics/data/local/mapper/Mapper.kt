package com.hassanwasfy.foodics.data.local.mapper

import com.hassanwasfy.foodics.data.models.local.CategoryEntity
import com.hassanwasfy.foodics.data.models.local.ProductEntity
import com.hassanwasfy.foodics.data.models.remote.ProductRemote
import com.hassanwasfy.foodics.ui.models.domain.Category
import com.hassanwasfy.foodics.ui.models.domain.Product

fun ProductRemote.toProductEntity(): ProductEntity {
    return ProductEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        image = this.image,
        price = this.price.toDouble(),
        category = CategoryEntity(
            categoryId = this.category_id,
            categoryName = this.category_name
        )
    )
}

fun ProductEntity.toDomainModel(): Product {
    return Product(
        id = this.id,
        name = this.name,
        description = this.description,
        image = this.image,
        price = this.price,
        category = Category(
            id = this.category.categoryId,
            name = this.category.categoryName
        )
    )
}
