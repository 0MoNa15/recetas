package com.mona15.infraestructure.recipe.list.anticorruption

import com.mona15.domain.recipe.list.model.Recipe
import com.mona15.infraestructure.anticorruption.Mapper
import com.mona15.infraestructure.recipe.list.dto.RecipeDto

class RecipeTranslate {
    companion object {

        fun mapRecipeDtoToDomain(recipeDto: RecipeDto): Recipe {
            return Mapper.convert(recipeDto)
        }

        fun mapRecipesDtoToDomain(recipeListDto: List<RecipeDto>): List<Recipe> {
            return recipeListDto.map { mapRecipeDtoToDomain(it) }
        }
    }
}