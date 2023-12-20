package com.mona15.domain.recipe.detail.model

import com.mona15.domain.recipe.list.model.RecipeBuilder
import com.mona15.domain.recipe.model.Recipe
import com.mona15.domain.recipe.model.RecipeDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Builder {
    companion object {
        fun getFlowRecipe (): Flow<RecipeDetail> {
            return flow { emit(RecipeDetailBuilder.getRecipe("Ajiaco")) }
        }

        fun getRecipe (): Recipe = RecipeBuilder.getRecipe("Ajiaco")

    }
}