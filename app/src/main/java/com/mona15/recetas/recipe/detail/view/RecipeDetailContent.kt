package com.mona15.recetas.recipe.detail.view

import androidx.compose.runtime.Composable
import com.mona15.domain.recipe.model.Location
import com.mona15.domain.recipe.model.RecipeDetail

@Composable
fun RecipeDetailContent(
    recipe: RecipeDetail?,
    loading: Boolean,
    error: Boolean,
    popBackStack: () -> Unit,
    navigateToLocationMapScreen: (location: Location) -> Unit,
) {

}