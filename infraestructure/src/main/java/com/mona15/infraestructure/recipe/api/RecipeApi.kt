package com.mona15.infraestructure.recipe.api

import com.mona15.infraestructure.recipe.dto.ResponseRecipeDetailDto
import com.mona15.infraestructure.recipe.dto.ResponseRecipesDto
import retrofit2.http.GET
import retrofit2.http.Path

private const val RECIPE_PATH = "/recetaslistacolombiaperu"
private const val PATH_NAME_COUNTRY = "/nombrepais"
private const val RECIPE_PATH_BY_COUNTRY = "/recetas/{$PATH_NAME_COUNTRY}"
private const val PATH_ID_RECIPE = "/idreceta"
private const val RECIPE_DETAIL_PATH = "/receta/{$PATH_ID_RECIPE}"

interface RecipeApi {

    @GET(RECIPE_PATH)
    suspend fun getAllRecipes(): ResponseRecipesDto

    @GET(RECIPE_PATH_BY_COUNTRY)
    suspend fun getRecipesByCountry(
        @Path(PATH_NAME_COUNTRY) countryName: String = PATH_NAME_COUNTRY
    ): ResponseRecipesDto

    @GET(RECIPE_DETAIL_PATH)
    suspend fun getRecipeDetail(
        @Path(PATH_ID_RECIPE) countryId: String = PATH_ID_RECIPE
    ): ResponseRecipeDetailDto
}