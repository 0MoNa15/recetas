package com.mona15.recetas.recipe.detail.view.state

import com.mona15.domain.recipe.detail.model.RecipeDetail

data class RecipeDetailUiState (
    var loading: Boolean = false,
    var success: RecipeDetail? = null,
    var error: Boolean = false,
    var message: String = ""
)