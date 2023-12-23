package com.mona15.domain.recipe

import com.mona15.domain.recipe.model.RecipeDetail
import kotlinx.coroutines.flow.Flow

interface RecipeDetailRepository {
    fun getRecipeDetail(recipeId: String?): Flow<RecipeDetail>
}