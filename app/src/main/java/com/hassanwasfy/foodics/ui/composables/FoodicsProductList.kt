package com.hassanwasfy.foodics.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import com.hassanwasfy.foodics.ui.models.ui.ProductUi
import com.hassanwasfy.foodics.ui.theme.Gray_Background


@Composable
fun FoodicsProductList(productsList: List<ProductUi>, onClick: (id: String) -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier
            .background(Gray_Background), columns = GridCells.Fixed(2)
    ) {
        items(productsList, key = { it.id }) {
            Card(onClick = { onClick(it.id) }) {
                Column {
                    AsyncImage(
                        model = it.image,
                        contentDescription = null,
                    )
                    Row {
                        Text(it.name)
                        Text("${it.price}")
                    }
                    Text(it.desc)
                }
            }
        }
    }
}