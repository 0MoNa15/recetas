package com.mona15.recetas.recipe.detail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mona15.recetas.recipe.detail.model.RecipeDetailBuilder
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
    fun testExistenceOfNameInRecipeDetail_Successful() {
        // Arrange
        val cardTag = "cardTag"
        val ajiacoRecipeList = RecipeBuilder().build()
        val ajiacoRecipeDetail = RecipeDetailBuilder().build()
        val recipes = listOf(ajiacoRecipeList)

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
        composeTestRule.onNodeWithText(ajiacoRecipeDetail.name).performClick()

        // Assert

        // Prueba incompleta
    }

}