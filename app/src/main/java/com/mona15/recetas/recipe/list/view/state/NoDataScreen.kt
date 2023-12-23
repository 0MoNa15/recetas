package com.mona15.recetas.recipe.list.view.state

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import com.mona15.recetas.R

@Composable
fun NoDataScreen(
    message: String,
    image: Painter
) {
    Image(
        painter = image,
        contentDescription = message,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_image_not_found))
            .fillMaxSize()
    )
}