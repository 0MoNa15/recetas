package com.mona15.domain.recipe.exceptions

private const val NO_DATA_RECIPE_EXCEPTION_CODE = 404

class NoDataRecipeException (codeMessage: Int = NO_DATA_RECIPE_EXCEPTION_CODE) : RecipeException(codeMessage.toString())