package com.mona15.domain.recipe.repository

import com.mona15.domain.recipe.model.Recipe
import com.mona15.domain.recipe.model.RecipeDetail
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getAllRecipes(): Flow<List<Recipe>>
    fun getRecipesByCountry(nameCountry: String): Flow<List<Recipe>>
    fun getRecipeDetail(recipeId: String): Flow<RecipeDetail>
}