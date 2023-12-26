package com.mona15.recetas.recipe.list

import com.mona15.domain.recipe.list.model.Recipe
import com.mona15.domain.recipe.list.usecases.GetAllRecipesUseCase
import com.mona15.domain.recipe.list.usecases.GetRecipesByCountryUseCase
import com.mona15.recetas.common.CoroutineTestRule
import com.mona15.recetas.recipe.list.viewmodel.RecipeListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
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
class RecipeLisViewModelTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Mock
    private lateinit var getAllRecipesUseCase: GetAllRecipesUseCase

    @Mock
    private lateinit var getRecipesByCountryUseCase: GetRecipesByCountryUseCase

    private lateinit var recipeListViewModel: RecipeListViewModel

    @Before
    fun setUp() {
        recipeListViewModel =
            RecipeListViewModel(getAllRecipesUseCase = getAllRecipesUseCase, getRecipesByCountryUseCase = getRecipesByCountryUseCase)
    }

    @Test
    fun `getRecipe() exitoso, debería devolver una lista de recetas válida`() {
        runBlocking {
            //Arrange
            val flowRecipes: Flow<List<Recipe>> = Builder.getFlowRecipes()
            Mockito.`when`(getAllRecipesUseCase.invoke()).thenReturn(flowRecipes)

            //Act
            recipeListViewModel.getAllRecipes()

            //Assert
            Mockito.verify(getAllRecipesUseCase, Mockito.times(1)).invoke()
        }
    }
}