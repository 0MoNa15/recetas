package com.mona15.infraestructure.recipe.detail.repository

import com.mona15.infraestructure.recipe.detail.anticorruption.RecipeDetailTranslate
import com.mona15.infraestructure.recipe.detail.model.ResponseRecipeDetailDtoBuilder
import com.mona15.infraestructure.recipe.detail.api.RecipeDetailApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.flow.first
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
        val expectedDomainDetail = RecipeDetailTranslate.mapRecipDetailDtoToDomain(recipeDetailDto)

        Mockito.`when`(recipeDetailApi.getRecipeDetail(recipeId)).thenReturn(recipeDetailDto)

        // Act
        val result = recipeDetailRepository.getRecipeDetail(recipeId).first()

        // Assert
        Mockito.verify(recipeDetailApi).getRecipeDetail(recipeId)
        assertEquals(expectedDomainDetail, result)
    }
}