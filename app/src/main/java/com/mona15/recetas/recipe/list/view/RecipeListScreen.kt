package com.mona15.recetas.recipe.list.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15.recetas.recipe.list.viewmodel.RecipeListViewModel

@Composable
fun RecipeListScreen(
    navigateToDetailRecipeScreen: (recipeId: String) -> Unit,
    viewModel: RecipeListViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    viewModel.getAllRecipes()

    Surface(Modifier.fillMaxSize()) {
        RecipeListContent(
            loading = uiState.value.loading,
            recipes = uiState.value.success,
            error = uiState.value.error,
            navigateToDetailRecipeScreen = navigateToDetailRecipeScreen,
        )
    }
}