package com.mona15.infraestructure.recipe.list.repository

import com.mona15.infraestructure.recipe.list.anticorruption.RecipeTranslate
import com.mona15.infraestructure.recipe.list.api.RecipeApi
import com.mona15.infraestructure.recipe.list.dto.ResponseRecipesDto
import com.mona15.infraestructure.recipe.list.model.RecipeDtoBuilder
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RecipeListRetrofitRepositoryUnitTest {

    @Mock
    private lateinit var recipeApi: RecipeApi

    @InjectMocks
    private lateinit var recipeRepository: RecipeListRetrofitRepository

    @Test
    fun `getAllRecipes() debería devolver una lista de recetas válida`() = runTest {
        // Arrange
        val recipeDtoList = listOf(
            RecipeDtoBuilder().build(),
            RecipeDtoBuilder()
                .withId("COL007")
                .withName("Tamal")
                .withIngredients(listOf("Masa de maíz", "Carne de pollo", "Verduras variadas", "Salsa"))
                .withUrlImage("https://i.ibb.co/9ZY7XSf/tamal.jpg")
                .build()
        )
        val responseRecipesDto = ResponseRecipesDto(recipeDtoList)
        Mockito.`when`(recipeApi.getAllRecipes()).thenReturn(responseRecipesDto)
        val expectedDomainList = RecipeTranslate.mapRecipesDtoToDomain(recipeDtoList)

        // Act
        val result = recipeRepository.getAllRecipes().first()

        // Assert
        Mockito.verify(recipeApi).getAllRecipes()
        Assert.assertEquals(expectedDomainList, result)
    }
}