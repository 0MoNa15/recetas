package com.mona15.infraestructure.recipe.anticorruption

import com.mona15.domain.recipe.model.Recipe
import com.mona15.infraestructure.recipe.list.dto.RecipeDto
import com.mona15.infraestructure.recipe.list.dto.ResponseRecipesDto
import com.mona15.infraestructure.recipe.list.anticorruption.RecipeTranslate
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
@RunWith(MockitoJUnitRunner::class)
class RecipeTranslateTest {

    private val recipeTranslate = RecipeTranslate

    private val recipe = Recipe(
        "COL001",
        "Ajiaco",
        listOf(
            "Papa criolla",
            "Pollo",
            "Mazorca",
            "Caldo de pollo",
            "Alcaparras",
            "Crema de leche"
        ),
        "https://i.ibb.co/zGcGtwh/ajiaco.jpg"
    )

    private val recipeDto = RecipeDto(
        "COL001",
        "Ajiaco",
        listOf(
            "Papa criolla",
            "Pollo",
            "Mazorca",
            "Caldo de pollo",
            "Alcaparras",
            "Crema de leche"
        ),
        "https://i.ibb.co/zGcGtwh/ajiaco.jpg"
    )

    private val recipesList = listOf(recipeDto)

    private val recipesDto = ResponseRecipesDto(recipesList)

    @Test
    fun mapRecipe_WhenEntityToDomain_RecipeReturn() {
        // Arrange
        val recipe = recipe
        // Act
        val result = recipeTranslate.mapRecipeDtoToDomain(recipeDto)
        // Assert
        Assert.assertTrue(result.javaClass == Recipe::class.java)
    }

    @Test
    fun mapRecipes_WhenRecipesDtoToDomain_RecipesReturn() {
        // Arrange
        val recipes = recipesDto.recipes
        // Act
        val result = recipeTranslate.mapRecipesDtoToDomain(recipes)
        // Assert
        Assert.assertTrue(result.all { it.javaClass == Recipe::class.java })
    }
}