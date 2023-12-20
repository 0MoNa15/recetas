package com.mona15.recetas.map.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.mona15.recetas.R
import com.mona15.recetas.map.model.LocationParcelable

@Composable
fun MapScreen(
    location: LocationParcelable?,
    popBackStack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_24_dp))
    ) {
        if (location != null) {
            Text(
                text = "Ubicación: ${location.toString()}",
                //style = TextStyle(fontSize = 20.sp)
            )
        } else {
            Text(
                text = "Ubicación no disponible",
                //style = TextStyle(fontSize = 20.sp)
            )
        }

        // Agrega más contenido o interacciones según sea necesario
    }
}