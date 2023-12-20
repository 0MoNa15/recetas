package com.mona15.recetas.recipe.detail

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mona15.recetas.recipe.detail.model.RecipeDetailBuilder
import com.mona15.recetas.recipe.detail.view.RecipeDetailContent
import com.mona15.recetas.ui.theme.RecetasTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExistenceOfButtonToGoToMapTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun validateExistenceOfButtonToGoToMapTest_Successful() {
        // Arrange
        val expectedTextButton = "Ver lugar de origen"

        // Action

        // Assert
    }
}