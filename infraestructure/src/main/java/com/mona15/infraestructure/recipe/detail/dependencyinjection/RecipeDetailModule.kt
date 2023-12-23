package com.mona15.infraestructure.recipe.detail.dependencyinjection

import com.mona15.domain.recipe.RecipeDetailRepository
import com.mona15.domain.recipe.usecases.GetRecipeDetailUseCase
import com.mona15.infraestructure.recipe.detail.api.RecipeDetailApi
import com.mona15.infraestructure.recipe.detail.repository.RecipeDetailRetrofitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RecipeDetailModule {
    @Provides
    fun provideRecipeDetailRepository(recipeDetailApi: RecipeDetailApi): RecipeDetailRepository = RecipeDetailRetrofitRepository(recipeDetailApi)

    @Provides
    fun getRecipeDetail (recipeDetailRepository: RecipeDetailRepository) : GetRecipeDetailUseCase = GetRecipeDetailUseCase(recipeDetailRepository)
}
