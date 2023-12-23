package com.mona15.domain.recipe.list

import com.mona15.domain.recipe.list.model.Builder
import com.mona15.domain.recipe.list.model.Recipe
import com.mona15.domain.recipe.list.repository.RecipeListRepository
import com.mona15.domain.recipe.list.usecases.GetAllRecipesUseCase
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
class GetAllRecipesUseCaseTest {
    @Mock
    lateinit var recipeListRepository: RecipeListRepository

    @InjectMocks
    lateinit var getAllRecipesUseCase: GetAllRecipesUseCase

    private val flowRecipe: Flow<List<Recipe>> = Builder.getFlowListRecipe()

    @Test
    fun `invoke should return flow of all recipes from repository`() {
        runBlocking {
            // Arrange
            Mockito.`when`(recipeListRepository.getAllRecipes()).thenReturn(flowRecipe)

            // Act
            val result = getAllRecipesUseCase.invoke()

            // Assert
            Mockito.verify(recipeListRepository, Mockito.times(1)).getAllRecipes()
            Assert.assertEquals(flowRecipe,result)
        }
    }
}