package com.hassanwasfy.foodics.ui.screens.products

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import com.hassanwasfy.foodics.R
import com.hassanwasfy.foodics.ui.composables.FoodicsAnimation
import com.hassanwasfy.foodics.ui.composables.FoodicsProductList
import com.hassanwasfy.foodics.ui.composables.ScreenBase
import com.hassanwasfy.foodics.ui.theme.Gray_Background
import com.hassanwasfy.foodics.ui.theme.Green_Circle
import com.hassanwasfy.foodics.ui.theme.Primary_Color
import com.hassanwasfy.foodics.ui.util.Fonts
import com.hassanwasfy.foodics.ui.util.Paddings
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenProducts(viewModel: ProductsViewModel = koinViewModel()) {
    val state = viewModel.state.collectAsState()
    ScreenProductsContent(state.value, viewModel)
}

@Composable
fun ScreenProductsContent(state: ProductsUiState, interaction: ProductsInterActions) {

    ScreenBase(
        isLoading = state.isLoading, isError = state.error.isError, errorMsg = state.error.message
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Paddings.DP_16, vertical = Paddings.DP_4),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_person_24),
                    "",
                    tint = Primary_Color
                )
                Text(
                    text = state.userName,
                    modifier = Modifier
                        .padding(horizontal = Paddings.DP_4)
                        .weight(1f)
                )
                Text(
                    text = state.userNumber, modifier = Modifier.padding(end = Paddings.DP_4)
                )
                Icon(
                    painter = painterResource(R.drawable.baseline_circle_24),
                    "",
                    tint = Green_Circle
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Paddings.TOP_BAR_HEIGHT)
                    .padding(Paddings.DP_16),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_back_24),
                    "",
                    modifier = Modifier.scale(1.2f)
                )
                Text(
                    text = "Menu",
                    modifier = Modifier
                        .padding(start = Paddings.DP_12)
                        .weight(1f),
                    fontSize = Fonts.SP_20,
                    fontWeight = FontWeight.Medium
                )
                Icon(
                    painter = painterResource(R.drawable.baseline_restaurant_24), "",
                )
                Text(
                    text = state.tableNumber,
                    modifier = Modifier.padding(horizontal = Paddings.DP_4)
                )
                Icon(
                    painterResource(R.drawable.baseline_people_alt_24),
                    "",
                    modifier = Modifier.padding(end = Paddings.DP_4)
                )
                Text(
                    text = state.peopleCount
                )
            }

            val keyboardController = LocalSoftwareKeyboardController.current

            Row(
                modifier = Modifier.padding(horizontal = Paddings.DP_16, vertical = Paddings.DP_4)
            ) {
                OutlinedTextField(
                    value = state.searchValue,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Paddings.SEARCH_VIEW_HEIGHT),
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
                    textStyle = TextStyle(
                        fontSize = Fonts.SP_14, fontWeight = FontWeight.Light
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_search_24),
                            "",
                            modifier = Modifier.padding(horizontal = Paddings.DP_8)
                        )
                    },
                    placeholder = {
                        Text(
                            "Search for products or categories.",
                            color = Color.Gray,
                            style = TextStyle(
                                fontSize = Fonts.SP_14, fontWeight = FontWeight.Light
                            )
                        )
                    },
                    onValueChange = interaction::onSearchQuery
                )
            }

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(
                    horizontal = Paddings.DP_16, vertical = Paddings.DP_4
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Paddings.DP_8)
            ) {
                items(state.categoryList, key = { it.id }) { category ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(CornerSize(Paddings.DP_8)))
                            .clickable {
                                interaction.onCategoryClick(category.id)
                            }
                            .padding(vertical = Paddings.DP_4)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = category.name,
                                fontSize = Fonts.SP_14,
                                fontWeight = if (state.currentCategory == category.id) {
                                    FontWeight.Bold
                                } else {
                                    FontWeight.Light
                                },
                                modifier = Modifier.padding(bottom = Paddings.DP_1)
                            )
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(CornerSize(Paddings.DP_4)))
                                    .height(Paddings.DP_1)
                                    .fillParentMaxWidth(0.1f)
                                    .background(
                                        if (state.currentCategory == category.id) {
                                            Primary_Color
                                        } else {
                                            Color.Transparent
                                        }
                                    )
                            )
                        }
                    }
                }
            }



            Box(modifier = Modifier.weight(1f)) {

                FoodicsAnimation(state.filteredList.isEmpty()) {
                    FoodicsProductList(state.productsList) { id ->
                        interaction.onCLickProduct(id)
                    }
                }

                FoodicsAnimation(state.filteredList.isNotEmpty()) {
                    FoodicsProductList(state.filteredList) { id ->
                        interaction.onCLickProduct(id)
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Gray_Background)
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(vertical = Paddings.DP_8, horizontal = Paddings.DP_16)
                ) {
                    Row(modifier = Modifier
                        .clip(RoundedCornerShape(CornerSize(Paddings.DP_8)))
                        .clickable { interaction.onClickViewOrder() }
                        .background(Primary_Color)
                        .padding(horizontal = Paddings.DP_16, vertical = Paddings.DP_12),
                        verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.White)
                        ) {
                            Text(
                                "${state.orderList.size}",
                                fontSize = Fonts.SP_12,
                                modifier = Modifier.padding(horizontal = Paddings.DP_8),
                                color = Primary_Color
                            )
                        }
                        Text(
                            "View Order",
                            modifier = Modifier
                                .padding(start = Paddings.DP_8)
                                .weight(1f),
                            color = Color.White
                        )
                        Text(
                            "SAR ${state.totalAmount}",
                            modifier = Modifier.padding(end = Paddings.DP_4),
                            color = Color.White
                        )
                        Icon(
                            painterResource(R.drawable.baseline_arrow_forward_24),
                            "",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

