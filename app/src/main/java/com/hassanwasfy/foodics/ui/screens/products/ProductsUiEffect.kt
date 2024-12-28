package com.hassanwasfy.foodics.ui.screens.products

import com.hassanwasfy.foodics.ui.base.BaseUiEffect

sealed class ProductsUiEffect: BaseUiEffect{
    // This class is used to handle the user intents
    // like navigating from a screen to another
    // using the NavigationHandler in the navigation package
    data object NavigateUp : ProductsUiEffect()
}
