package com.mona15.infraestructure.recipe.list.api

import com.mona15.infraestructure.recipe.list.dto.ResponseRecipesDto
import retrofit2.http.GET
import retrofit2.http.Path

private const val RECIPE_PATH = "/recetaslistacolombiaperu"
private const val PATH_NAME_COUNTRY = "/nombrepais"
private const val RECIPE_PATH_BY_COUNTRY = "/recetas/{$PATH_NAME_COUNTRY}"
private const val PATH_ID_RECIPE = "/idreceta"

interface RecipeApi {

    @GET(RECIPE_PATH)
    suspend fun getAllRecipes(): ResponseRecipesDto

    @GET(RECIPE_PATH_BY_COUNTRY)
    suspend fun getRecipesByCountry(
        @Path(PATH_NAME_COUNTRY) countryName: String = PATH_NAME_COUNTRY
    ): ResponseRecipesDto
}