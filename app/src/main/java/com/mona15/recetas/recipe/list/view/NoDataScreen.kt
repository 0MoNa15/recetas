package com.mona15.recetas.recipe.list.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mona15.recetas.R

@Composable
fun NoDataScreen() {
   val image: Painter = painterResource(id = R.drawable.nointernet)
    Image(
        painter = image,
        contentDescription = stringResource(id = R.string.no_data_description),
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_92dp))
            .fillMaxSize()
    )
}