package com.mona15.recetas.recipe.detail.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15.domain.recipe.model.Location
import com.mona15.recetas.recipe.detail.RecipeDetailViewModel

@Composable
fun RecipeDetailScreen(
    recipeId: String?,
    popBackStack: () -> Unit,
    navigateToLocationMapScreen: (location: Location) -> Unit,
    recipeDetailViewModel: RecipeDetailViewModel = hiltViewModel()
) {
    val uiState by recipeDetailViewModel.uiState.collectAsState()
    recipeDetailViewModel.getRecipe(recipeId)

    Surface(Modifier.fillMaxSize()) {
        RecipeDetailContent(
            loading = uiState.loading,
            recipe = uiState.success,
            error = uiState.error,
            popBackStack = popBackStack,
            navigateToLocationMapScreen = navigateToLocationMapScreen
        )
    }
}