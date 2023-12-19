package com.mona15.recetas.recipe.list.view.state

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.mona15.recetas.R

@Composable
fun EmptyListView(callToAction: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(dimensionResource(id = R.dimen.padding_double)),
        verticalArrangement = Arrangement.Center
    ) {
        val emptyListText = stringResource(R.string.no_se_ha_ecnontrado_receta)
        Text(
            text = emptyListText,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        val reloadText = stringResource(R.string.recargar_las_recetas)
        Button(
            onClick = callToAction,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = reloadText)
        }
    }
}
