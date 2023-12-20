package com.mona15.domain.recipe.list.model

import com.mona15.domain.recipe.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Builder {
    companion object{
        fun getFlowListRecipe (): Flow<List<Recipe>> {
            val movies = listOf(
                RecipeBuilder.getRecipe("Ajiaco"),
                RecipeBuilder.getRecipe("Causa Rellena")
            )
            return flow { emit(movies) }
        }

        fun getListRecipe (): List<Recipe> = listOf(
            RecipeBuilder.getRecipe("Ajiaco"),
            RecipeBuilder.getRecipe("Causa Rellena")
        )

    }
}