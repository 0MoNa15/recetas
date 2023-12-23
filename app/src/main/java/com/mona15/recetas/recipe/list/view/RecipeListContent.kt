package com.mona15.recetas.recipe.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.mona15.domain.recipe.model.Recipe
import com.mona15.recetas.R
import com.mona15.recetas.recipe.list.view.state.EmptyListView
import com.mona15.recetas.recipe.list.view.state.NoDataScreen
import com.mona15.recetas.recipe.list.viewmodel.RecipeListViewModel

@Composable
fun RecipeListContent(
    recipes: List<Recipe>,
    loading: Boolean,
    error: Boolean,
    navigateToDetailRecipeScreen: (recipeId: String) -> Unit,
    viewModel: RecipeListViewModel? = hiltViewModel()
) {
    Column{
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
                .testTag(stringResource(id = R.string.recipe_list_tag))
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
                    NoDataScreen(message = stringResource(R.string.no_se_ha_encontrado_la_vista), painterResource(id = R.drawable.lista_404))
                } else {
                    RecipeListView(
                        recipes = recipesFilter,
                        navigateToDetailRecipeScreen = navigateToDetailRecipeScreen,
                        reloadRecipes = {
                            viewModel?.getAllRecipes()
                        }
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
            .testTag(stringResource(id = R.string.search_tag))
            .padding(dimensionResource(id = R.dimen.padding_double))
    )
}


@Composable
fun RecipeListView(
    recipes: List<Recipe>,
    navigateToDetailRecipeScreen: (recipeId: String) -> Unit,
    reloadRecipes: () -> Unit
) {
    if (recipes.isEmpty()) {
        EmptyListView(callToAction = reloadRecipes)
    } else {
        LazyColumn(
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.no_padding)),
            verticalArrangement = Arrangement.Center,
        ) {
            itemsIndexed(recipes) { _, item ->
                RecipeCard(
                    recipe = item,
                    navigateToDetailRecipeScreen = navigateToDetailRecipeScreen)
            }
        }
    }
}

@Composable
fun RecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier,
    navigateToDetailRecipeScreen: (recipeId: String) -> Unit,
) {
    Card(
        modifier = modifier
            .testTag(stringResource(id = R.string.recipe_card_tag))
            .clickable {
                navigateToDetailRecipeScreen.invoke(recipe.id)
            }
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_double)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner)),
        elevation = dimensionResource(id = R.dimen.card_elevation),
    ) {
        Box(modifier = Modifier.height(dimensionResource(id = R.dimen.card_size))) {
            AsyncImage(
                model = recipe.urlImage,
                contentDescription = null,
                modifier = Modifier
                    .testTag(stringResource(id = R.string.image_card_tag))
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.DarkGray
                            ),
                            startY = 100f
                        )
                    )
            ) {
            }
            Box(
                modifier = Modifier
                    .testTag(stringResource(id = R.string.text_card_tag))
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_double)),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(recipe.name, 
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp
                    )
                )
            }
        }
    }
}