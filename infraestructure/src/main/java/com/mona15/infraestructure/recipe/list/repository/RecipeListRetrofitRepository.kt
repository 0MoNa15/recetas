package com.mona15.infraestructure.recipe.list.repository

import com.mona15.domain.recipe.exceptions.NoDataRecipeException
import com.mona15.domain.recipe.list.model.Recipe
import com.mona15.domain.recipe.list.repository.RecipeListRepository
import com.mona15.infraestructure.anticorruption.Mapper
import com.mona15.infraestructure.recipe.list.anticorruption.RecipeTranslate
import com.mona15.infraestructure.recipe.list.api.RecipeApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class RecipeListRetrofitRepository(private val recipeApi: RecipeApi) : RecipeListRepository {
    override fun getAllRecipes(): Flow<List<Recipe>> {
        return flow { emit(recipeApi.getAllRecipes()) }
            .catch {
                throw NoDataRecipeException()
            }.map {
                RecipeTranslate.mapRecipesDtoToDomain(it.recipes)
            }
    }

    override fun getRecipesByCountry(nameCountry: String): Flow<List<Recipe>> {
        return flow { emit(recipeApi.getRecipesByCountry(nameCountry)) }
            .catch {
                throw NoDataRecipeException()
            }.map {
                RecipeTranslate.mapRecipesDtoToDomain(it.recipes)
            }
    }
}