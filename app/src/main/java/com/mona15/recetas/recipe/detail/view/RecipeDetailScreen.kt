package com.mona15.recetas.recipe.detail.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15.domain.country.model.Country
import com.mona15.domain.recipe.model.Ingredient
import com.mona15.domain.recipe.model.Location
import com.mona15.domain.recipe.model.Macronutrient
import com.mona15.domain.recipe.model.RecipeDetail
import com.mona15.recetas.recipe.detail.RecipeDetailViewModel

@Composable
fun RecipeDetailScreen(
    recipeId: String?,
    popBackStack: () -> Unit,
    navigateToLocationMapScreen: (location: Location) -> Unit,
    recipeDetailViewModel: RecipeDetailViewModel = hiltViewModel()
) {
    val uiState by recipeDetailViewModel.uiState.collectAsState()
    //recipeDetailViewModel.getRecipe(recipeId)

    val recipeDetail = RecipeDetail(
        id = recipeId!!,
        name = "Ajiaco",
        description = "Sopa colombiana espesa y nutritiva.",
        image = "https://i.ibb.co/zGcGtwh/ajiaco.jpg",
        ingredients = listOf(
            Ingredient("Papa criolla", 200, "gramos"),
            Ingredient("Pollo", 300, "gramos"),
            Ingredient("Mazorca", 1, "unidad"),
            Ingredient("Caldo de pollo", 1, "litro"),
            Ingredient("Alcaparras", 50, "gramos"),
            Ingredient("Crema de leche", 100, "mililitros")
        ),
        macronutrients = Macronutrient(400, 25, 10, 50),
        location = Location(4.6097, -74.0817, "Bogotá", Country("Colombia", "https://ibb.co/wdzWDHD")),
        preparationTimeMinutes = 40,
        slices = 4,
        difficulty = "Media",
        instructions = listOf(
            "1. Lavar y pelar las papas criollas.",
            "2. Cocinar el pollo en una olla grande con agua.",
            "3. Agregar las papas criollas, la mazorca, el caldo, y otros ingredientes.",
            "4. Cocinar hasta que las papas estén suaves y el caldo espese.",
            "5. Servir caliente y agregar alcaparras y crema al gusto."
        )
    )

    Surface(Modifier.fillMaxSize()) {
        RecipeDetailContent(
            loading = uiState.loading,
            //recipe = uiState.success,
            recipe = recipeDetail,
            error = uiState.error,
            popBackStack = popBackStack,
            navigateToLocationMapScreen = navigateToLocationMapScreen
        )
    }
}