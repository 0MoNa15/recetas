package com.mona15.domain.recipe.usecases

import com.mona15.domain.recipe.model.Recipe
import com.mona15.domain.recipe.repository.RecipeListRepository
import kotlinx.coroutines.flow.Flow

class GetAllRecipesUseCase constructor(private val recipeListRepository: RecipeListRepository) {
    suspend operator fun invoke(): Flow<List<Recipe>> = recipeListRepository.getAllRecipes()
}