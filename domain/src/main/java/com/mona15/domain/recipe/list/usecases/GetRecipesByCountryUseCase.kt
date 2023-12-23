package com.mona15.domain.recipe.list.usecases

import com.mona15.domain.recipe.list.model.Recipe
import com.mona15.domain.recipe.list.repository.RecipeListRepository
import kotlinx.coroutines.flow.Flow

class GetRecipesByCountryUseCase constructor(private val recipeListRepository: RecipeListRepository) {
    suspend operator fun invoke(nameCountry: String): Flow<List<Recipe>> =
        recipeListRepository.getRecipesByCountry(nameCountry)
}