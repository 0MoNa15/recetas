package com.mona15.recetas.recipe.list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mona15.domain.recipe.model.Recipe
import com.mona15.recetas.recipe.list.model.RecipeBuilder
import com.mona15.recetas.recipe.list.view.RecipeListContent
import com.mona15.recetas.ui.theme.RecetasTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ButtonToReloadRecipeListTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testButtonToReloadRecipeList() {
        // Arrange
        val testTag = "searchTag"
        val recipeSearch = "Receta que no existe"
        val expectedTextButton = "Recargar las recetas"
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

        // Action
        composeTestRule.onNodeWithText(expectedTextButton).assertIsDisplayed()
    }
}