package com.mona15.recetas.recipe.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import coil.compose.AsyncImage
import com.mona15.domain.recipe.model.Recipe
import com.mona15.recetas.R

@Composable
fun RecipeListView(recipes: List<Recipe>) {
    if (recipes.isEmpty()) {
        EmptyListView()
    } else {
        LazyColumn(
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.no_padding)),
            verticalArrangement = Arrangement.Center,
        ) {
            itemsIndexed(recipes) { _, item ->
                RecipeCard(recipe = item)
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
            .padding(dimensionResource(id = R.dimen.padding_double)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner)),
        elevation = dimensionResource(id = R.dimen.card_elevation),
    ) {
        Box(modifier = Modifier.height(dimensionResource(id = R.dimen.card_size))) {
            AsyncImage(
                model = recipe.urlImage,
                contentDescription = null,
                modifier = Modifier
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
                            startY = 100f,
                            //endY = 0.1f
                        )
                    )
            ) {
            }
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