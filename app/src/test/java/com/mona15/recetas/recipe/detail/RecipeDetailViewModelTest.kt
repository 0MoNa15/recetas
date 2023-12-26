package com.mona15.recetas.recipe.detail

import com.mona15.recetas.recipe.detail.viewmodel.RecipeDetailViewModel
import com.mona15.domain.recipe.detail.usecase.GetRecipeDetailUseCase
import com.mona15.domain.recipe.detail.model.RecipeDetail
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.runner.RunWith
import org.junit.Before
import org.mockito.Mock
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config
import org.mockito.Mockito

@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
@ExperimentalCoroutinesApi
class RecipeDetailViewModelTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Mock
    private lateinit var getRecipeDetailUseCase: GetRecipeDetailUseCase

    private lateinit var recipeDetailViewModel: RecipeDetailViewModel

    @Before
    fun setUp() {
        recipeDetailViewModel =
            RecipeDetailViewModel(getRecipeDetailUseCase = getRecipeDetailUseCase)
    }

    @Test
    fun `getRecipe() exitoso, debería devolver un detalle de receta válido`() {
        runBlocking {
            //Arrange
            val recipeId = "COL001"
            val flowRecipeDetail: Flow<RecipeDetail> = Builder.getFlowRecipeDetail()
            Mockito.`when`(getRecipeDetailUseCase.invoke(recipeId = recipeId)).thenReturn(flowRecipeDetail)

            //Act
            recipeDetailViewModel.getRecipe(recipeId)

            //Assert
            Mockito.verify(getRecipeDetailUseCase, Mockito.times(1)).invoke("recipeId")
        }
    }
}