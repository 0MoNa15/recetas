package com.mona15.infraestructure.recipe.anticorruption

import com.mona15.domain.recipe.model.Recipe
import com.mona15.infraestructure.anticorruption.Mapper
import com.mona15.infraestructure.recipe.dto.RecipeDto

class RecipeTranslate {
    companion object {

        private fun mapRecipeDtoToDomain(movieDto: RecipeDto): Recipe {
            return Mapper.convert(movieDto)
        }

        fun mapRecipesDtoToDomain(recipeListDto: List<RecipeDto>): List<Recipe> {
            return recipeListDto.map { mapRecipeDtoToDomain(it) }
        }
    }
}