package com.mona15.infraestructure.recipe.detail.api

import com.mona15.infraestructure.recipe.detail.dto.ResponseRecipeDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeDetailApi {

    @GET("/receta/{recipeId}")
    suspend fun getRecipeDetail(
        @Path("recipeId") recipeId: String
    ): ResponseRecipeDetailDto
}
