package com.mona15.recetas.recipe.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15.domain.recipe.model.Recipe
import com.mona15.recetas.R
import com.mona15.recetas.recipe.list.viewmodel.RecipeListViewModel

@Composable
fun RecipeListScreen(
    navigateToDetailRecipeScreen: (recipeId: Int) -> Unit,
    viewModel: RecipeListViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    viewModel.getAllRecipes()

    /*val recipes = listOf(
        Recipe("1", "Ajiaco", listOf("Harina", "Azúcar", "Huevos", "Levadura", "Sal"), "https://i.ibb.co/smHpRvH/rocoto-relleno.jpg"),
        Recipe("2", "Tamal", listOf("Harina", "Azúcar", "Dulce", "Levadura", "Sal"), "https://i.ibb.co/smHpRvH/rocoto-relleno.jpg"),
        Recipe("3", "Ajiaco", listOf("Harina", "Azúcar", "Huevos", "Levadura", "Sal"), "https://i.ibb.co/smHpRvH/rocoto-relleno.jpg"),
        // Agrega más recetas según sea necesario
    )*/

    Surface(Modifier.fillMaxSize()) {
        RecipeListContent(
            loading = uiState.value.loading,
            //recipes = recipes,
            recipes = uiState.value.success,
            error = uiState.value.error
        )
    }
}

@Composable
fun RecipeListContent(
    recipes: List<Recipe>,
    loading: Boolean,
    error: Boolean
) {
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 1f,
                        endY = 0f
                    )
                )
        ) {
            val appBarColor = MaterialTheme.colors.surface.copy(alpha = 0.87f)
            Spacer(
                Modifier
                    .background(appBarColor)
                    .fillMaxWidth()
            )

            val recipesFilter = recipes.toMutableStateList()
            val search: (value: String) -> Unit = { query ->
                val result = recipes.filter { recipe ->
                    recipe.name.contains(query, ignoreCase = true) ||
                    recipe.ingredients.any { it.contains(query, ignoreCase = true) }
                }

                recipesFilter.apply {
                    clear()
                    addAll(result)
                }
            }

            FieldSearch(search)

            if (loading) {
                WaitingRecipesList()
            } else {
                if (error) {
                    NoDataScreen()
                } else {
                    RecipeListView(
                        recipes = recipesFilter
                    )
                }
            }
        }
    }
}

@Composable
private fun FieldSearch(search: (value: String) -> Unit) {
    var searchTerm by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchTerm,
        onValueChange = {
            searchTerm = it
            search(it)
        },
        label = {
            val text = stringResource(id = R.string.search_recipe)
            Text(text = text)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_double)),
    )
}