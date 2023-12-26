package com.mona15.recetas.recipe.list

import com.mona15.domain.recipe.list.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Builder {
    companion object {
        fun getFlowRecipes(): Flow<List<Recipe>> {
            return flow { emit(getRecipes()) }
        }

        fun getRecipes(): List<Recipe> {
            return listOf(
                RecipeBuilder().build()
            )
        }
    }
}