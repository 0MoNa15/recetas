package com.mona15.recetas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mona15.recetas.recipe.detail.view.RecipeDetailScreen
import com.mona15.recetas.recipe.list.view.RecipeListScreen

private const val RECIPE_LIST_SCREEN_ROUTE = "recipe_list_screen"
private const val RECIPE_DETAIL_SCREEN_ROUTE = "recipe_detail_screen"
private const val LOCATION_MAP_SCREEN_ROUTE = "recipe_detail_screen"
private const val RECIPE_ID_ARGUMENT = "recipe_id"
private const val LOCATION_ARGUMENT = "ubicacion"

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = RECIPE_LIST_SCREEN_ROUTE) {

        composable(RECIPE_LIST_SCREEN_ROUTE) {
            RecipeListScreen(
                navigateToDetailRecipeScreen = {
                    navController.navigate("${RECIPE_DETAIL_SCREEN_ROUTE}/${it}")
                }
            )
        }

        composable("${RECIPE_DETAIL_SCREEN_ROUTE}/{${RECIPE_ID_ARGUMENT}}",
            arguments = listOf(
                navArgument(RECIPE_ID_ARGUMENT) {
                    type = NavType.IntType
                }
            )) {

            val recipeId = remember {
                it.arguments?.getString(RECIPE_ID_ARGUMENT)
            }

            RecipeDetailScreen(
                recipeId = recipeId,
                popBackStack = {
                    navController.popBackStack()
                },
                navigateToLocationMapScreen = {
                    navController.navigate("${LOCATION_MAP_SCREEN_ROUTE}/${it}")
                }
            )
        }

        /*composable("${LOCATION_MAP_SCREEN_ROUTE}/{${RECIPE_ID_ARGUMENT}}",
            arguments = listOf(
                navArgument(LOCATION_ARGUMENT) {
                    type = NavType.IntType
                }
            )) {

            val location = remember {
                it.arguments?.getParcelable(LOCATION_ARGUMENT)
            }

            LocationMapScreen(
                navigateToLocationMapScreen = {
                    navController.navigate("${LOCATION_MAP_SCREEN_ROUTE}/${it}")
                },
                recipeId = recipeId,
                popBackStack = {
                    navController.popBackStack()
                })
        }*/
    }
}