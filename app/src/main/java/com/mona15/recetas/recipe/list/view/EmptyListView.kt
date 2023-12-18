package com.mona15.recetas.recipe.list.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource

@Composable
fun EmptyListView(callToAction: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(dimensionResource(id = com.mona15.recetas.R.dimen.padding_double)),
        verticalArrangement = Arrangement.Center
    ) {
        val emptyListText = "Lista vacia"
        Text(
            text = emptyListText,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .testTag("titleEmptyList")
        )
        val reloadText = "Re-cargar"
        Button(
            onClick = callToAction,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = reloadText)
        }
    }
}
