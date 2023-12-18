package com.mona15.recetas.recipe.detail

import com.mona15.domain.recipe.model.RecipeDetail
import com.mona15.recetas.BaseUiState

data class RecipeDetailUiState (
    var success: RecipeDetail
) : BaseUiState()