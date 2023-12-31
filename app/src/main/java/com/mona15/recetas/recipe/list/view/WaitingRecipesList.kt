package com.mona15.recetas.recipe.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.mona15.recetas.R

@Composable
fun WaitingRecipesList() {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.no_padding)),
        verticalArrangement = Arrangement.Center
    ) {
        items(10) {
            WaintingRecipeCard()
        }
    }
}


@Composable
fun WaintingRecipeCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .testTag(stringResource(id = R.string.card_tag))
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner)),
        elevation = dimensionResource(id = R.dimen.card_elevation),
    ) {
        Box(modifier = Modifier.height(dimensionResource(id = R.dimen.card_size))) {
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
                    .padding(dimensionResource(id = R.dimen.padding_double)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}