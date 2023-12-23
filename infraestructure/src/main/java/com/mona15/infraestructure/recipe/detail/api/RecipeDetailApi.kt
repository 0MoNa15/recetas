package com.mona15.infraestructure.recipe.detail.api

import com.mona15.infraestructure.recipe.detail.dto.ResponseRecipeDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

private const val PATH_ID_RECIPE = "/idreceta"
private const val RECIPE_DETAIL_PATH = "/receta/{$PATH_ID_RECIPE}"

interface RecipeDetailApi {
    @GET(RECIPE_DETAIL_PATH)
    suspend fun getRecipeDetail(
        @Path(PATH_ID_RECIPE) recipeId: String = PATH_ID_RECIPE
    ): ResponseRecipeDetailDto
}
