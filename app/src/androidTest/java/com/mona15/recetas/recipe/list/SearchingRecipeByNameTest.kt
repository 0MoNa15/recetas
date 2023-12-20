package com.mona15.recetas.recipe.list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4

import com.mona15.recetas.recipe.list.model.RecipeBuilder
import com.mona15.recetas.recipe.list.view.RecipeListContent
import com.mona15.recetas.recipe.list.viewmodel.RecipeListViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.mona15.recetas.ui.theme.RecetasTheme

@RunWith(AndroidJUnit4::class)
class SearchingRecipeByNameTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSearchRecipeByNameWithA_SuccessfulResult() {
        // Arrange
        val testTag = "searchTag"
        val recipeSearch = "Ajiaco"
        val ajiacoRecipe = RecipeBuilder().build()
        val tamalRecipe = RecipeBuilder()
            .withId("COL007")
            .withName("Tamal")
            .withIngredients(listOf("Masa de maíz", "Carne de pollo", "Verduras variadas", "Salsa"))
            .withUrlImage("https://i.ibb.co/9ZY7XSf/tamal.jpg")
            .build()

        val recipes = listOf(
            ajiacoRecipe,
            tamalRecipe
        )

        // Action
        composeTestRule.setContent {
            RecetasTheme {
                RecipeListContent(
                    recipes = recipes,
                    loading = false,
                    error = false,
                    navigateToDetailRecipeScreen = { },
                    null
                )
            }
        }
        val searchField = composeTestRule.onNodeWithTag(testTag)
        searchField.performTextInput(recipeSearch)
        searchField.performTextClearance()

        // Assert
        composeTestRule.onNodeWithText(recipeSearch).assertIsDisplayed()
    }

    @Test
    fun testSearchRecipeByNameWithA_FailedResult() {
        // Arrange
        val testTag = "searchTag"
        val recipeSearch = "Ajiaco"
        val expectedNotExist = "Tamal"
        val ajiacoRecipe = RecipeBuilder().build()
        val tamalRecipe = RecipeBuilder()
            .withId("COL007")
            .withName(expectedNotExist)
            .withIngredients(listOf("Masa de maíz", "Carne de pollo", "Verduras variadas", "Salsa"))
            .withUrlImage("https://i.ibb.co/9ZY7XSf/tamal.jpg")
            .build()

        val recipes = listOf(
            ajiacoRecipe,
            tamalRecipe
        )

        composeTestRule.setContent {
            RecetasTheme {
                RecipeListContent(
                    recipes = recipes,
                    loading = false,
                    error = false,
                    navigateToDetailRecipeScreen = { },
                    null
                )
            }
        }

        // Action
        val searchField = composeTestRule.onNodeWithTag(testTag)
        searchField.performTextInput(recipeSearch)

        repeat(recipeSearch.length) {
            searchField.performTextInput("\b")
        }

        // Assert
        composeTestRule.onNodeWithText(expectedNotExist).assertDoesNotExist()
    }
}