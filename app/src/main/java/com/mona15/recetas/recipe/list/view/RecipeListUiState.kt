package com.mona15.recetas.recipe.list.view

import com.mona15.domain.recipe.model.Recipe

data class RecipeListUiState(
    var loading: Boolean = false,
    var success: List<Recipe> = emptyList(),
    var error: Boolean = false,
    var message: String = "",
)
