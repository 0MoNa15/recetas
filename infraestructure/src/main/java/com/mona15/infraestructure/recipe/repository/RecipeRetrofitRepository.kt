package com.mona15.infraestructure.recipe.repository

import com.mona15.domain.recipe.exceptions.NoDataRecipeException
import com.mona15.domain.recipe.model.Recipe
import com.mona15.domain.recipe.model.RecipeDetail
import com.mona15.domain.recipe.repository.RecipeRepository
import com.mona15.infraestructure.anticorruption.Mapper
import com.mona15.infraestructure.recipe.anticorruption.RecipeTranslate
import com.mona15.infraestructure.recipe.api.RecipeApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class RecipeRetrofitRepository(private val recipeApi: RecipeApi) : RecipeRepository {
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
                Mapper.convert(it.recipes)
            }
    }

    override fun getRecipeDetail(recipeId: String?): Flow<RecipeDetail> {
        return if (recipeId != null){
            flow { emit(recipeApi.getRecipeDetail(recipeId)) }
                .catch {
                    throw NoDataRecipeException()
                }.map {
                    Mapper.convert(it)
                }
        } else {
            throw NoDataRecipeException()
        }
    }
}