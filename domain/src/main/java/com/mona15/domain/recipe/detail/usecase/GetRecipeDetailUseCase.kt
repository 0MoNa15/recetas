package com.mona15.domain.recipe.detail.usecase

import com.mona15.domain.recipe.detail.repository.RecipeDetailRepository
import com.mona15.domain.recipe.detail.model.RecipeDetail
import kotlinx.coroutines.flow.Flow

class GetRecipeDetailUseCase constructor(private val recipeDetailRepository: RecipeDetailRepository) {
    suspend operator fun invoke(recipeId: String?): Flow<RecipeDetail> =
        recipeDetailRepository.getRecipeDetail(recipeId)
}