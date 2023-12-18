package com.mona15.recetas.recipe.list

import com.mona15.domain.recipe.model.Recipe
import com.mona15.recetas.BaseUiState

data class RecipeListUiState(
    var success: List<Recipe> = emptyList()
) : BaseUiState()
