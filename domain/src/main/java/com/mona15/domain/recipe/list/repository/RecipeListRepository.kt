package com.mona15.domain.recipe.list.repository

import com.mona15.domain.recipe.list.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeListRepository {
    fun getAllRecipes(): Flow<List<Recipe>>
    fun getRecipesByCountry(nameCountry: String): Flow<List<Recipe>>
}