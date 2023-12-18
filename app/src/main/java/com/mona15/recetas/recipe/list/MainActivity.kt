package com.mona15.recetas.recipe.list

import com.mona15.recetas.R
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle

import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.mona15.domain.recipe.model.Recipe
import com.mona15.recetas.ui.theme.RecetasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecetasTheme {
                RecipeListScreen()
            }
        }
    }
}

@Composable
fun RecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner)),
        elevation = dimensionResource(id = R.dimen.card_elevation),
    ) {
        Box(modifier = Modifier.height(dimensionResource(id = R.dimen.card_size))) {
            AsyncImage(
                model = recipe.urlImage,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
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
                            startY = 300f
                        )
                    )
            ) {
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color.DarkGray,
                                Color.Transparent,
                                Color.Transparent,
                                Color.DarkGray
                            )
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_double)),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(recipe.name, style = TextStyle(color = Color.White))
            }
        }
    }
}


@Composable
fun RecipesList(
    recipes: List<Recipe>,
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.no_padding)),
        verticalArrangement = Arrangement.Center,
    ) {
        itemsIndexed(recipes) { _, item ->
            RecipeCard(recipe = item)
        }
    }
}


@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    viewModel.getAllRecipes()

    Surface(Modifier.fillMaxSize()) {
        HomeContent(
            loading = uiState.value.loading,
            recipes = uiState.value.success,
            error = uiState.value.error,
        )
    }
}


@Composable
fun HomeContent(
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
            /*HomeAppBar(
                backgroundColor = appBarColor,
                modifier = Modifier.fillMaxWidth()
            )*/
            if (loading) {
                //RecipeListPreview()
            } else {
                if (error) {
                    //NoDataScreen()
                } else {
                    RecipesList(
                        recipes = recipes,
                    )
                }
            }
        }
    }
}