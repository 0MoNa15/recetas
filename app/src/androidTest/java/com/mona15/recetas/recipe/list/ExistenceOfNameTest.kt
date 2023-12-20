package com.mona15.recetas.recipe.list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mona15.recetas.recipe.list.model.RecipeBuilder
import com.mona15.recetas.recipe.list.view.RecipeListContent
import com.mona15.recetas.ui.theme.RecetasTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExistenceOfNameTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testExistenceOfNameInRecipeList() {
        // Arrange
        val ajiacoRecipe = RecipeBuilder().build()
        val recipes = listOf(ajiacoRecipe)

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


        // Assert
        recipes.forEach { recipe ->
            composeTestRule.onNodeWithText(recipe.name).assertIsDisplayed()
        }
    }
}
