package com.mona15.domain.recipe.detail

import com.mona15.domain.recipe.detail.model.Builder
import com.mona15.domain.recipe.model.RecipeDetail
import com.mona15.domain.recipe.repository.RecipeRepository
import com.mona15.domain.recipe.usecases.GetRecipeDetailUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetRecipeDetailUseCaseTest {
    @Mock
    lateinit var recipeRepository: RecipeRepository

    @InjectMocks
    lateinit var getDetailUseCase: GetRecipeDetailUseCase

    private val recipe = Builder.getRecipe()
    private val flowRecipe: Flow<RecipeDetail> = Builder.getFlowRecipe()

    @Test
    fun `invoke should return the detail of a single recipe`() {
        runBlocking {
            // Arrange
            val idRecipe = recipe.id
            Mockito.`when`(recipeRepository.getRecipeDetail(idRecipe)).thenReturn(flowRecipe)

            // Act
            val result = getDetailUseCase.invoke(idRecipe)

            // Assert
            Mockito.verify(recipeRepository, Mockito.times(1)).getRecipeDetail(idRecipe)
            Assert.assertEquals(flowRecipe,result)
        }
    }
}