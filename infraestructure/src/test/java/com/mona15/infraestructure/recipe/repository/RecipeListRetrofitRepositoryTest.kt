package com.mona15.infraestructure.recipe.repository

import com.mona15.infraestructure.anticorruption.Mapper
import com.mona15.infraestructure.recipe.list.api.RecipeApi
import com.mona15.infraestructure.recipe.list.dto.ResponseRecipesDto
import com.mona15.infraestructure.recipe.model.RecipeDtoBuilder
import com.mona15.infraestructure.recipe.list.repository.RecipeListRetrofitRepository
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RecipeListRetrofitRepositoryTest {

    @Mock
    private lateinit var recipeApi: RecipeApi

    @Mock
    private lateinit var mapper: Mapper

    @InjectMocks
    private lateinit var recipeRepository: RecipeListRetrofitRepository

    @Test
    fun getAllRecipes_whenApiReturnsRecipes_returnMappedRecipes() {
        runBlocking {
            // Arrange
            val ajiacoRecipe = RecipeDtoBuilder().build()
            val tamalRecipe = RecipeDtoBuilder()
                .withId("COL007")
                .withName("Tamal")
                .withIngredients(listOf("Masa de maíz", "Carne de pollo", "Verduras variadas", "Salsa"))
                .withUrlImage("https://i.ibb.co/9ZY7XSf/tamal.jpg")
                .build()

            val recipesDto = listOf(
                ajiacoRecipe,
                tamalRecipe
            )

            val responseRecipesDto = ResponseRecipesDto(recipesDto)
            Mockito.`when`(recipeApi.getAllRecipes()).thenReturn(responseRecipesDto)

            // Act
            val result = recipeRepository.getAllRecipes().toList()

            // Assert
            // Falta MapperTest
            //Assert.assertEquals(listOf(recipes), result)
        }
    }
}
