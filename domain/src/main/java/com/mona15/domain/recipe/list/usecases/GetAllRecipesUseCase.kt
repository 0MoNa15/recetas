package com.mona15.domain.recipe.list.usecases

import com.mona15.domain.recipe.list.model.Recipe
import com.mona15.domain.recipe.list.repository.RecipeListRepository
import kotlinx.coroutines.flow.Flow

class GetAllRecipesUseCase constructor(private val recipeListRepository: RecipeListRepository) {
    suspend operator fun invoke(): Flow<List<Recipe>> = recipeListRepository.getAllRecipes()
}