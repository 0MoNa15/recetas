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
import com.mona15.recetas.ui.theme.RecetasTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchingRecipeByIngredientTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSearchRecipeByIngredientWithA_SuccessfulResult() {
        // Arrange
        val testTag = "searchTag"
        val ingredientSearch = "papa"
        val expectedRecipeCausa = "Causa Rellena"

        val ajiacoRecipe = RecipeBuilder().build()
        val tamalRecipe = RecipeBuilder()
            .withId("COL007")
            .withName("Tamal")
            .withIngredients(listOf("Masa de maíz", "Carne de pollo", "Verduras variadas", "Salsa"))
            .withUrlImage("https://i.ibb.co/9ZY7XSf/tamal.jpg")
            .build()
        val causaRellenaRecipe = RecipeBuilder()
            .withId("PER006")
            .withName(expectedRecipeCausa)
            .withIngredients(listOf("Papas amarillas", "Ají amarillo", "Limón", "Pollo", "Mayonesa", "Aguacate"))
            .withUrlImage("https://i.ibb.co/3W319RZ/causa-rellena.jpg")
            .build()

        val recipes = listOf(
            ajiacoRecipe,
            tamalRecipe,
            causaRellenaRecipe
        )

        val recipesExpected = listOf(
            ajiacoRecipe,
            causaRellenaRecipe
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
        searchField.performTextInput(ingredientSearch)
        searchField.performTextClearance()

        // Assert
        recipesExpected.forEach { expectedRecipe ->
            composeTestRule.onNodeWithText(expectedRecipe.name).assertIsDisplayed()
        }
    }

    @Test
    fun testSearchRecipeByIngredientWithA_FailedResult() {
        // Arrange
        val testTag = "searchTag"
        val ingredientSearch = "papa"
        val expectedRecipeCausa = "Causa Rellena"

        val ajiacoRecipe = RecipeBuilder().build()
        val tamalRecipe = RecipeBuilder()
            .withId("COL007")
            .withName("Tamal")
            .withIngredients(listOf("Masa de maíz", "Carne de pollo", "Verduras variadas", "Salsa"))
            .withUrlImage("https://i.ibb.co/9ZY7XSf/tamal.jpg")
            .build()
        val causaRellenaRecipe = RecipeBuilder()
            .withId("PER006")
            .withName(expectedRecipeCausa)
            .withIngredients(listOf("Papas amarillas", "Ají amarillo", "Limón", "Pollo", "Mayonesa", "Aguacate"))
            .withUrlImage("https://i.ibb.co/3W319RZ/causa-rellena.jpg")
            .build()

        val recipes = listOf(
            ajiacoRecipe,
            tamalRecipe,
            causaRellenaRecipe
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
        searchField.performTextInput(ingredientSearch)
        searchField.performTextInput("\b")

        // Assert
        composeTestRule.onNodeWithText(tamalRecipe.name).assertDoesNotExist()
    }
}