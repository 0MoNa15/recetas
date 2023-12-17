package com.mona15.infraestructure.recipe.dependencyinjection

import com.mona15.domain.recipe.repository.RecipeRepository
import com.mona15.infraestructure.recipe.api.RecipeApi
import com.mona15.infraestructure.recipe.repository.RecipeRetrofitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RecipeModule {

    @Provides
    fun provideRecipeRepository(recipeApi: RecipeApi): RecipeRepository =
        RecipeRetrofitRepository(recipeApi)
}