package com.mona15.domain.recipe.usecases

import com.mona15.domain.recipe.model.Recipe
import com.mona15.domain.recipe.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow

class GetRecipesByCountryUseCase constructor(private val recipeRepository: RecipeRepository) {
    suspend operator fun invoke(nameCountry: String): Flow<List<Recipe>> =
        recipeRepository.getRecipesByCountry(nameCountry)
}