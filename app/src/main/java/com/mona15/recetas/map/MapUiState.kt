package com.mona15.recetas.map

import com.mona15.domain.recipe.model.Location
import com.mona15.recetas.BaseUiState

data class MapUiState (
    var success: Location
) : BaseUiState()