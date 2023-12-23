package com.mona15.domain.recipe.list.usecase

import com.mona15.domain.recipe.list.model.Builder
import com.mona15.domain.recipe.list.model.Recipe
import com.mona15.domain.recipe.list.repository.RecipeListRepository
import com.mona15.domain.recipe.list.usecases.GetRecipesByCountryUseCase
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
class GetRecipesByCountryUseCaseTest {
    @Mock
    lateinit var recipeListRepository: RecipeListRepository

    @InjectMocks
    lateinit var getRecipesByCountryUseCase: GetRecipesByCountryUseCase

    private val flowRecipe: Flow<List<Recipe>> = Builder.getFlowListRecipe()

    @Test
    fun `invoke should return the flow of recipes from a single country`() {
        runBlocking {
            // Arrange
            val countryName = "Colombia"
            Mockito.`when`(recipeListRepository.getRecipesByCountry(countryName)).thenReturn(flowRecipe)

            // Act
            val result = getRecipesByCountryUseCase.invoke(countryName)

            // Assert
            Mockito.verify(recipeListRepository, Mockito.times(1)).getRecipesByCountry(countryName)
            Assert.assertEquals(flowRecipe,result)
        }
    }
}