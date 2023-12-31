package com.mona15.infraestructure.recipe.detail.repository

import com.mona15.domain.recipe.detail.repository.RecipeDetailRepository
import com.mona15.domain.recipe.exceptions.NoDataRecipeException
import com.mona15.domain.recipe.detail.model.RecipeDetail
import com.mona15.infraestructure.recipe.detail.anticorruption.RecipeDetailTranslate
import com.mona15.infraestructure.recipe.detail.api.RecipeDetailApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class RecipeDetailRetrofitRepository(private val recipeDetailApi: RecipeDetailApi) : RecipeDetailRepository {

    override fun getRecipeDetail(recipeId: String?): Flow<RecipeDetail> {
        return if (recipeId != null) {
            flow {
                val response = recipeDetailApi.getRecipeDetail(recipeId = recipeId)
                if (response == null) {
                    throw NoDataRecipeException()
                } else {
                    emit(response)
                }
            }
                .catch { 
                    throw NoDataRecipeException()
                }.map {
                    RecipeDetailTranslate.mapRecipeDetailDtoToDomain(it)

                }
        } else {
            throw NoDataRecipeException()
        }
    }
}
