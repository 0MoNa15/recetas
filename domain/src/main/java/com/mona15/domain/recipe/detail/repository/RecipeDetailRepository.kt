package com.mona15.domain.recipe.detail.repository

import com.mona15.domain.recipe.detail.model.RecipeDetail
import kotlinx.coroutines.flow.Flow

interface RecipeDetailRepository {
    fun getRecipeDetail(recipeId: String?): Flow<RecipeDetail>
}