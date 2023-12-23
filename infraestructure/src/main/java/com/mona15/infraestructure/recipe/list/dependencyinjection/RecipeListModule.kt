package com.mona15.infraestructure.recipe.list.dependencyinjection

import com.mona15.domain.recipe.repository.RecipeListRepository
import com.mona15.domain.recipe.usecases.GetAllRecipesUseCase
import com.mona15.domain.recipe.usecases.GetRecipesByCountryUseCase
import com.mona15.infraestructure.recipe.list.api.RecipeApi
import com.mona15.infraestructure.recipe.list.repository.RecipeListRetrofitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RecipeListModule {

    @Provides
    fun provideRecipeRepository(recipeApi: RecipeApi): RecipeListRepository = RecipeListRetrofitRepository(recipeApi)

    @Provides
    fun getAllRecipes (recipeListRepository: RecipeListRepository) : GetAllRecipesUseCase = GetAllRecipesUseCase(recipeListRepository)

    @Provides
    fun getRecipesByCountry (recipeListRepository: RecipeListRepository) : GetRecipesByCountryUseCase = GetRecipesByCountryUseCase(recipeListRepository)
}