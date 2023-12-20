package com.mona15.recetas.common

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mona15.recetas.country.model.LocalizationParcelableNavType
import com.mona15.recetas.map.model.LocationParcelable
import com.mona15.recetas.map.view.MapScreen
import com.mona15.recetas.recipe.detail.view.RecipeDetailScreen
import com.mona15.recetas.recipe.list.view.RecipeListScreen
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

private const val RECIPE_LIST_SCREEN_ROUTE = "recipe_list_screen"
private const val RECIPE_DETAIL_SCREEN_ROUTE = "recipe_detail_screen"
private const val LOCATION_MAP_SCREEN_ROUTE = "location_map_screen"
private const val RECIPE_ID_ARGUMENT = "recipe_id"
private const val LOCATION_ARGUMENT = "location"

@Composable
fun Navigation(isLoading: (Boolean) -> Unit, loadingSplashScreen: Boolean) {
    if (loadingSplashScreen) {
        SplashScreen(isLoading = isLoading)
    } else {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = RECIPE_LIST_SCREEN_ROUTE) {

            composable(RECIPE_LIST_SCREEN_ROUTE) {
                RecipeListScreen(
                    navigateToDetailRecipeScreen = {
                        navController.navigate("$RECIPE_DETAIL_SCREEN_ROUTE/${it}")
                    }
                )
            }

            composable("$RECIPE_DETAIL_SCREEN_ROUTE/{$RECIPE_ID_ARGUMENT}") {
                val recipeId = remember {
                    it.arguments?.getString(RECIPE_ID_ARGUMENT)
                }

                RecipeDetailScreen(
                    recipeId = recipeId,
                    navigateToLocationMapScreen = { locationParcelable ->
                        navController.navigate("$LOCATION_MAP_SCREEN_ROUTE/${
                            Uri.encode(Json.encodeToJsonElement(locationParcelable).toString())
                        }")

                    }
                )
            }

            composable(
                route = "$LOCATION_MAP_SCREEN_ROUTE/{$LOCATION_ARGUMENT}",
                arguments = listOf(navArgument(LOCATION_ARGUMENT) {
                    type = LocalizationParcelableNavType
                })
            ) {
                val location = it.arguments?.getParcelable<LocationParcelable>(LOCATION_ARGUMENT)

                MapScreen(
                    location = location,
                    popBackStack = {
                        navController.popBackStack()
                    })
            }
        }
    }
}