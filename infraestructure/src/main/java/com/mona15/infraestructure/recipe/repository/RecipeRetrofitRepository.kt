package com.mona15.infraestructure.recipe.repository

import com.mona15.infraestructure.recipe.api.RecipeApi

class RecipeRetrofitRepository(private val recipeApi: RecipeApi) : RecipeRepository {
}