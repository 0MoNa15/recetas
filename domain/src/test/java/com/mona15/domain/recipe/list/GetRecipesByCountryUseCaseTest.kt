package com.mona15.domain.recipe.list

import com.mona15.domain.recipe.list.model.Builder
import com.mona15.domain.recipe.model.Recipe
import com.mona15.domain.recipe.repository.RecipeRepository
import com.mona15.domain.recipe.usecases.GetAllRecipesUseCase
import com.mona15.domain.recipe.usecases.GetRecipesByCountryUseCase
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
    lateinit var recipeRepository: RecipeRepository

    @InjectMocks
    lateinit var getRecipesByCountryUseCase: GetRecipesByCountryUseCase

    private val flowRecipe: Flow<List<Recipe>> = Builder.getFlowListRecipe()

    @Test
    fun `invoke should return the flow of recipes from a single country`() {
        runBlocking {
            // Arrange
            val countryName = "Colombia"
            Mockito.`when`(recipeRepository.getRecipesByCountry(countryName)).thenReturn(flowRecipe)

            // Act
            val result = getRecipesByCountryUseCase.invoke(countryName)

            // Assert
            Mockito.verify(recipeRepository, Mockito.times(1)).getRecipesByCountry(countryName)
            Assert.assertEquals(flowRecipe,result)
        }
    }
}