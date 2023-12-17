package com.mona15.infraestructure.recipe.dependencyinjection

import com.mona15.domain.recipe.repository.RecipeRepository
import com.mona15.domain.recipe.usecases.GetAllRecipesUseCase
import com.mona15.domain.recipe.usecases.GetRecipeDetailUseCase
import com.mona15.domain.recipe.usecases.GetRecipesByCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun getAllRecipes (recipeRepository: RecipeRepository) : GetAllRecipesUseCase = GetAllRecipesUseCase(recipeRepository)

    @Provides
    fun getRecipesByCountry (recipeRepository: RecipeRepository) : GetRecipesByCountryUseCase = GetRecipesByCountryUseCase(recipeRepository)

    @Provides
    fun getRecipeDetail (recipeRepository: RecipeRepository) : GetRecipeDetailUseCase = GetRecipeDetailUseCase(recipeRepository)
}