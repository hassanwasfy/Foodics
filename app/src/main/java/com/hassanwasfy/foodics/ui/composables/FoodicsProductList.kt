package com.hassanwasfy.foodics.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.hassanwasfy.foodics.R
import com.hassanwasfy.foodics.ui.models.ui.ProductUi
import com.hassanwasfy.foodics.ui.theme.Gray_Background
import com.hassanwasfy.foodics.ui.theme.Primary_Color
import com.hassanwasfy.foodics.ui.theme.Red_Circle
import com.hassanwasfy.foodics.ui.util.Fonts
import com.hassanwasfy.foodics.ui.util.Paddings

@Composable
fun FoodicsProductList(productsList: List<ProductUi>, onClick: (id: String) -> Unit) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(
            start = Paddings.DP_16,
            end = Paddings.DP_16,
            top = Paddings.DP_4,
            bottom = Paddings.DP_64
        ),
        verticalArrangement = Arrangement.spacedBy(Paddings.DP_8),
        horizontalArrangement = Arrangement.spacedBy(Paddings.DP_8),
        columns = GridCells.Fixed(2)
    ) {
        items(productsList, key = { it.id }) {
            Box(modifier = Modifier) {
                Column(
                    modifier = Modifier.fillMaxSize(0.95f)
                ) {
                    Spacer(Modifier.height(Paddings.DP_12))
                    Card(
                        onClick = { onClick(it.id) },
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(bottom = Paddings.DP_8)
                        ) {
                            AsyncImage(
                                model = it.image,
                                contentDescription = null,
                                placeholder = painterResource(id = R.drawable.placeholder),
                                error = painterResource(id = R.drawable.error),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(3 / 2f),
                                contentScale = ContentScale.FillBounds
                            )

                            Row(
                                modifier = Modifier.padding(Paddings.DP_8)
                            ) {
                                Text(
                                    it.name,
                                    fontSize = Fonts.SP_14,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.weight(1f)
                                )
                                Text(
                                    "${it.price}",
                                    fontSize = Fonts.SP_12,
                                    fontWeight = FontWeight.Light,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                            Text(
                                it.desc,
                                fontSize = Fonts.SP_12,
                                color = Color.LightGray,
                                maxLines = 1,
                                softWrap = false,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(horizontal = Paddings.DP_8)
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    FoodicsAnimation(it.count != 0) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Red_Circle)
                        ) {
                            Text(
                                "${it.count}",
                                fontSize = Fonts.SP_12,
                                modifier = Modifier.padding(horizontal = Paddings.DP_8),
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}