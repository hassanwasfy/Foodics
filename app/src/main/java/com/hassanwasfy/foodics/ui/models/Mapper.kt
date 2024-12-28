package com.hassanwasfy.foodics.ui.models

import com.hassanwasfy.foodics.ui.models.domain.Product
import com.hassanwasfy.foodics.ui.models.ui.ProductUi

fun Product.toUiModel(): ProductUi {
    return ProductUi(
        id = this.id,
        categoryId = this.category.id,
        name = this.name,
        image = this.image,
        count = 0,
        desc = this.description,
        price = this.price
    )
}