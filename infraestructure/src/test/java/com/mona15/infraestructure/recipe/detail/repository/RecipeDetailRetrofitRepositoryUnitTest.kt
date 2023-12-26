package com.mona15.infraestructure.recipe.detail.repository

import com.mona15.domain.recipe.exceptions.NoDataRecipeException
import com.mona15.infraestructure.recipe.detail.anticorruption.RecipeDetailTranslate
import com.mona15.infraestructure.recipe.detail.model.ResponseRecipeDetailDtoBuilder
import com.mona15.infraestructure.recipe.detail.api.RecipeDetailApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.junit.Test
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito

@RunWith(MockitoJUnitRunner::class)
class RecipeDetailRetrofitRepositoryUnitTest {

    @Mock
    private lateinit var recipeDetailApi: RecipeDetailApi

    @InjectMocks
    private lateinit var recipeDetailRepository: RecipeDetailRetrofitRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getRecipeDetail() exitoso, debería devolver una receta válida`() = runTest {
        // Arrange
        val recipeId = "COL001"
        val recipeDetailDto = ResponseRecipeDetailDtoBuilder().build()
        val expectedDomainDetail = RecipeDetailTranslate.mapRecipeDetailDtoToDomain(recipeDetailDto)

        Mockito.`when`(recipeDetailApi.getRecipeDetail(recipeId)).thenReturn(recipeDetailDto)

        // Act
        val result = recipeDetailRepository.getRecipeDetail(recipeId).first()

        // Assert
        Mockito.verify(recipeDetailApi).getRecipeDetail(recipeId)
        assertEquals(expectedDomainDetail, result)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getRecipeDetail() con ID nulo, debería lanzar NoDataRecipeException`() = runTest {
        // Arrange
        val recipeId: String? = null

        // Act
        val exceptionResult = Assert.assertThrows(NoDataRecipeException::class.java) {
            runBlocking {
                recipeDetailRepository.getRecipeDetail(recipeId).first()
            }
        }

        // Assert
        assertEquals(NoDataRecipeException::class.java, exceptionResult.javaClass)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test(expected = NoDataRecipeException::class)
    fun `getRecipeDetail() con respuesta nula, debería lanzar NoDataRecipeException`() = runTest {
        // Arrange
        val recipeId = "COL001"

        Mockito.`when`(recipeDetailApi.getRecipeDetail(recipeId)).thenReturn(null)

        // Act
        recipeDetailRepository.getRecipeDetail(recipeId).first()
    }

}