package com.mona15.recetas.recipe.list.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15.domain.recipe.model.Recipe
import com.mona15.recetas.recipe.list.viewmodel.RecipeListViewModel

@Composable
fun RecipeListScreen(
    navigateToDetailRecipeScreen: (recipeId: String) -> Unit,
    viewModel: RecipeListViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    //viewModel.getAllRecipes()

    val recipes = listOf(
        Recipe("1", "Ajiaco", listOf("Harina", "Azúcar", "Huevos", "Levadura", "Sal"), "https://i.ibb.co/smHpRvH/rocoto-relleno.jpg"),
        Recipe("2", "Tamal", listOf("Harina", "Azúcar", "Dulce", "Levadura", "Sal"), "https://i.ibb.co/smHpRvH/rocoto-relleno.jpg"),
        Recipe("3", "Ajiaco", listOf("Harina", "Azúcar", "Huevos", "Levadura", "Sal"), "https://i.ibb.co/smHpRvH/rocoto-relleno.jpg"),
        // Agrega más recetas según sea necesario
    )

    Surface(Modifier.fillMaxSize()) {
        RecipeListContent(
            loading = uiState.value.loading,
            recipes = recipes,
            //recipes = uiState.value.success,
            error = uiState.value.error,
            navigateToDetailRecipeScreen = navigateToDetailRecipeScreen
        )
    }
}