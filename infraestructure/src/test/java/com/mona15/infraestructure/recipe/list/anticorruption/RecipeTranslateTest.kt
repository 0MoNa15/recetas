package com.mona15.infraestructure.recipe.list.anticorruption

import com.mona15.infraestructure.recipe.list.model.RecipeBuilder
import com.mona15.infraestructure.recipe.list.model.RecipeDtoBuilder
import org.mockito.junit.MockitoJUnitRunner
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.junit.Test

@RunWith(MockitoJUnitRunner::class)
class RecipeTranslateTest {

    @Test
    fun `mapRecipeDtoToDomain() debería asignar DTO al dominio`() {
        // Arrange
        val expectedRecipe = RecipeBuilder().build()
        val recipeDto = RecipeDtoBuilder().build()

        // Act
        val result = RecipeTranslate.mapRecipeDtoToDomain(recipeDto)

        // Assert
        assertEquals(expectedRecipe, result)
    }

    @Test
    fun `mapRecipesDtoToDomain() debería asignar lista de DTOs al dominio`() {
        // Arrange
        val recipeDtoList = listOf(
            RecipeDtoBuilder().build(),
            RecipeDtoBuilder()
                .withId("PER006")
                .withName("Causa Rellena")
                .withIngredients(listOf("Papas amarillas", "Ají amarillo", "Limón", "Pollo", "Mayonesa", "Aguacate"))
                .withUrlImage("https://i.ibb.co/3W319RZ/causa-rellena.jpg")
                .build()
        )

        val expectedRecipeList = listOf(
            RecipeBuilder().build(),
            RecipeBuilder()
                .withId("PER006")
                .withName("Causa Rellena")
                .withIngredients(listOf("Papas amarillas", "Ají amarillo", "Limón", "Pollo", "Mayonesa", "Aguacate"))
                .withUrlImage("https://i.ibb.co/3W319RZ/causa-rellena.jpg")
                .build()
        )

        // Act
        val result = RecipeTranslate.mapRecipesDtoToDomain(recipeDtoList)

        // Assert
        assertEquals(expectedRecipeList, result)
    }
}