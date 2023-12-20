package com.mona15.recetas.recipe.detail

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mona15.recetas.recipe.detail.model.RecipeDetailBuilder
import com.mona15.recetas.recipe.detail.view.RecipeDetailContent
import com.mona15.recetas.ui.theme.RecetasTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExistenceOfDescriptionTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testExistenceOfNameInRecipeDetail_Successful() {
        // Arrange
        val ajiacoRecipe = RecipeDetailBuilder().build()

        // Action
        composeTestRule.setContent {
            RecetasTheme {
                RecipeDetailContent(
                    recipe = ajiacoRecipe,
                    loading = false,
                    error = false,
                    navigateToLocationMapScreen = { }
                )
            }
        }

        // Assert
        composeTestRule.onNodeWithText(ajiacoRecipe.description).assertIsDisplayed()
        // Prueba incompleta
    }
}