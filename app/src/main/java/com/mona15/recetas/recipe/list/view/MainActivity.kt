package com.mona15.recetas.recipe.list.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.mona15.recetas.ui.theme.RecetasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecetasTheme {
                val navController = rememberNavController()

                RecipeListScreen( navigateToDetailRecipeScreen = {
                    navController.navigate("${"recipe_detail_screen"}/${it}")
                })
            }
        }
    }
}