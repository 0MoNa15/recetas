package com.mona15.domain.recipe.usecases

import com.mona15.domain.recipe.RecipeDetailRepository
import com.mona15.domain.recipe.model.RecipeDetail
import kotlinx.coroutines.flow.Flow

class GetRecipeDetailUseCase constructor(private val recipeDetailRepository: RecipeDetailRepository) {
    suspend operator fun invoke(recipeId: String?): Flow<RecipeDetail> =
        recipeDetailRepository.getRecipeDetail(recipeId)
}