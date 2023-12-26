package com.mona15.recetas.recipe.detail.viewmodel

import com.mona15.domain.recipe.detail.model.RecipeDetail
import com.mona15.domain.recipe.detail.usecase.GetRecipeDetailUseCase
import com.mona15.recetas.recipe.detail.Builder
import com.mona15.recetas.common.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config

@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
@ExperimentalCoroutinesApi
class RecipeDetailViewModelTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Mock
    private lateinit var getUseCaseDetailUseCase: GetRecipeDetailUseCase

    private lateinit var recipeDetailViewModel: RecipeDetailViewModel

    @Before
    fun setUp() {
        recipeDetailViewModel = RecipeDetailViewModel(getUseCaseDetailUseCase)
    }

    @Test
    fun `getRecipe() exitoso, debería devolver una receta válida`() {
        runBlocking {
            //Arrange
            val recipeId = "COL001"
            val flowRecipeDetail: Flow<RecipeDetail> = Builder.getFlowRecipeDetail()
            Mockito.`when`(getUseCaseDetailUseCase.invoke(recipeId)).thenReturn(flowRecipeDetail)

            //Act
            recipeDetailViewModel.getRecipe(recipeId)

            //Assert
            Mockito.verify(getUseCaseDetailUseCase, Mockito.times(1)).invoke(recipeId)
        }
    }
}