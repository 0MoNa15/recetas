package com.mona15.infraestructure.recipe.detail.repository

import com.mona15.domain.recipe.RecipeDetailRepository
import com.mona15.domain.recipe.exceptions.NoDataRecipeException
import com.mona15.domain.recipe.model.RecipeDetail
import com.mona15.infraestructure.anticorruption.Mapper
import com.mona15.infraestructure.recipe.detail.api.RecipeDetailApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class RecipeDetailRetrofitRepository(private val recipeDetailApi: RecipeDetailApi) : RecipeDetailRepository {

    override fun getRecipeDetail(recipeId: String?): Flow<RecipeDetail> {
        return if (recipeId != null){
            flow { emit(recipeDetailApi.getRecipeDetail(recipeId)) }
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
