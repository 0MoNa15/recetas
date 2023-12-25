package com.mona15.infraestructure.recipe.detail.anticorruption

import com.mona15.domain.country.model.Country
import com.mona15.domain.recipe.detail.model.Ingredient
import com.mona15.domain.recipe.detail.model.Location
import com.mona15.domain.recipe.detail.model.Macronutrient
import com.mona15.domain.recipe.detail.model.RecipeDetail
import com.mona15.infraestructure.country.dto.CountryDto
import com.mona15.infraestructure.recipe.detail.dto.IngredientDto
import com.mona15.infraestructure.recipe.detail.dto.LocationDto
import com.mona15.infraestructure.recipe.detail.dto.MacronutrientDto
import com.mona15.infraestructure.recipe.detail.dto.ResponseRecipeDetailDto

class RecipeDetailTranslate {
    companion object {
        fun mapRecipDetailDtoToDomain(recipeDetailDto: ResponseRecipeDetailDto): RecipeDetail {
            val recipe =  RecipeDetail(
                id = recipeDetailDto.id,
                name = recipeDetailDto.name,
                description = recipeDetailDto.description,
                image = recipeDetailDto.image,
                ingredients = mapIngredientsDtoToDomain(recipeDetailDto.ingredients),
                macronutrients = mapMacronutrientDtoToDomain(recipeDetailDto.macronutrients),
                location = mapLocationDtoToDomain(recipeDetailDto.location),
                preparationTimeMinutes = recipeDetailDto.preparationTimeMinutes,
                slices = recipeDetailDto.slices,
                difficulty = recipeDetailDto.difficulty,
                instructions = recipeDetailDto.instructions)

            return recipe
        }

        fun mapIngredientsDtoToDomain(ingredientsDto: List<IngredientDto>): List<Ingredient> {
            return ingredientsDto.map { mapIngredientDtoToDomain(it) }
        }

        private fun mapIngredientDtoToDomain(ingredientDto: IngredientDto): Ingredient {
            return Ingredient(
                name = ingredientDto.name,
                amount = ingredientDto.amount,
                presentation = ingredientDto.presentation
            )
        }

        fun mapMacronutrientDtoToDomain(macronutrientDto: MacronutrientDto): Macronutrient {
            return Macronutrient(
                calories = macronutrientDto.calories,
                proteins = macronutrientDto.proteins,
                fats = macronutrientDto.fats,
                carbohydrates = macronutrientDto.carbohydrates
            )
        }

        fun mapLocationDtoToDomain(locationDto: LocationDto): Location {
            return Location(
                latitude = locationDto.latitude,
                longitude = locationDto.longitude,
                city = locationDto.city,
                country = mapCountryDtoToDomain(locationDto.country)
            )
        }

        fun mapCountryDtoToDomain(countryDto: CountryDto): Country {
            return Country(
                name = countryDto.name,
                flag = countryDto.flag
            )
        }
    }
}