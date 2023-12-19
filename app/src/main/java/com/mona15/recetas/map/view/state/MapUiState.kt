package com.mona15.recetas.map.view.state

import com.mona15.domain.recipe.model.Location

data class MapUiState (
    var success: Location,
    var loading: Boolean = false,
    var error: Boolean = false,
    var message: String = ""
)