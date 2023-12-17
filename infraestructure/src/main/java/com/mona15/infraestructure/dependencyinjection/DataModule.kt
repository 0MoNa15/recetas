package com.mona15.infraestructure.dependencyinjection

import com.mona15.infraestructure.country.api.CountryApi
import com.mona15.infraestructure.country.repository.CountryRepository
import com.mona15.infraestructure.country.repository.CountryRetrofitRepository
import com.mona15.infraestructure.recipe.api.RecipeApi
import com.mona15.infraestructure.recipe.repository.RecipeRepository
import com.mona15.infraestructure.recipe.repository.RecipeRetrofitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun provideRecipeRepository(recipeApi: RecipeApi): RecipeRepository =
        RecipeRetrofitRepository(recipeApi)

    @Provides
    fun provideCountryRepository(countryApi: CountryApi): CountryRepository =
        CountryRetrofitRepository(countryApi)
}