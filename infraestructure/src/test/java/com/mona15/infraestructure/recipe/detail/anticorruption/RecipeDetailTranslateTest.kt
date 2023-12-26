package com.mona15.infraestructure.recipe.detail.anticorruption

import com.mona15.infraestructure.recipe.detail.model.CountryBuilder
import com.mona15.infraestructure.recipe.detail.model.CountryDtoBuilder
import com.mona15.infraestructure.recipe.detail.model.IngredientBuilder
import com.mona15.infraestructure.recipe.detail.model.IngredientDtoBuilder
import com.mona15.infraestructure.recipe.detail.model.LocationBuilder
import com.mona15.infraestructure.recipe.detail.model.LocationDtoBuilder
import com.mona15.infraestructure.recipe.detail.model.MacronutrientBuilder
import com.mona15.infraestructure.recipe.detail.model.MacronutrientDtoBuilder
import com.mona15.infraestructure.recipe.detail.model.RecipeDetailBuilder
import com.mona15.infraestructure.recipe.detail.model.ResponseRecipeDetailDtoBuilder
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RecipeDetailTranslateTest {

    @Test
    fun `mapRecipeDetailDtoToDomain() debería asignar DTO al dominio`() {
        // Arrange
        val expectedRecipeDetail = RecipeDetailBuilder().build()
        val recipeDetailDto = ResponseRecipeDetailDtoBuilder().build()

        // Act
        val result = RecipeDetailTranslate.mapRecipeDetailDtoToDomain(recipeDetailDto)

        // Assert
        assertEquals(expectedRecipeDetail, result)
    }

    @Test
    fun `mapIngredientsDtoToDomain() debería asignar la lista de ingredientes al dominio`() {
        // Arrange
        val ingredientDtoList = listOf(
            IngredientDtoBuilder().build(),
            IngredientDtoBuilder().withName("Mazorca").withAmount(1).withPresentation("Unidad").build()
        )

        val expectedIngredientList = listOf(
            IngredientBuilder().build(),
            IngredientBuilder().withName("Mazorca").withAmount(1).withPresentation("Unidad").build()
        )

        // Act
        val result = RecipeDetailTranslate.mapIngredientsDtoToDomain(ingredientDtoList)

        // Assert
        assertEquals(expectedIngredientList, result)
    }

    @Test
    fun `mapIngredientDtoToDomain() debería asignar el ingrediente al dominio`() {
        // Arrange
        val ingredientDto = IngredientDtoBuilder().build()
        val expectedIngredient = IngredientBuilder().build()

        // Act
        val result = RecipeDetailTranslate.mapIngredientDtoToDomain(ingredientDto)

        // Assert
        assertEquals(expectedIngredient, result)
    }

    @Test
    fun `mapMacronutrientDtoToDomain() debería asignar DTO al dominio`() {
        // Arrange
        val macronutrientDto = MacronutrientDtoBuilder().build()
        val expectedMacronutrient = MacronutrientBuilder().build()
        val recipeDetailDto = ResponseRecipeDetailDtoBuilder().build()

        // Act
        val result = RecipeDetailTranslate.mapMacronutrientDtoToDomain(macronutrientDto)
        RecipeDetailTranslate.mapRecipeDetailDtoToDomain(recipeDetailDto)

        // Assert
        assertEquals(expectedMacronutrient, result)
    }

    @Test
    fun `mapLocationDtoToDomain() debería asignar DTO al dominio`() {
        // Arrange
        val locationDto = LocationDtoBuilder().build()
        val expectedLocation = LocationBuilder().build()

        // Act
        val result = RecipeDetailTranslate.mapLocationDtoToDomain(locationDto)

        // Assert
        assertEquals(expectedLocation, result)
    }

    @Test
    fun `mapCountryDtoToDomain() debería asignar DTO al dominio`() {
        // Arrange
        val countryDto = CountryDtoBuilder().build()
        val expectedCountry = CountryBuilder().build()

        // Act
        val result = RecipeDetailTranslate.mapCountryDtoToDomain(countryDto)

        // Assert
        assertEquals(expectedCountry, result)
    }
}