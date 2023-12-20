package com.mona15.recetas

import android.net.Uri
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

        composable("${RECIPE_DETAIL_SCREEN_ROUTE}/{${RECIPE_ID_ARGUMENT}}") {
            val recipeId = remember {
                it.arguments?.getString(RECIPE_ID_ARGUMENT)
            }

            RecipeDetailScreen(
                recipeId = recipeId,
                popBackStack = {
                    navController.popBackStack()
                },
                navigateToLocationMapScreen = { locationParcelable ->
                    navController.navigate("${LOCATION_MAP_SCREEN_ROUTE}/${
                        Uri.encode(Json.encodeToJsonElement(locationParcelable).toString())
                    }")

                }
            )
        }

        composable(
            route = "${LOCATION_MAP_SCREEN_ROUTE}/{${LOCATION_ARGUMENT}}",
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

val LocalizationParcelableNavType = object : NavType<LocationParcelable>(isNullableAllowed = false){

    override fun put(bundle: Bundle, key: String, value: LocationParcelable) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): LocationParcelable? {
        return bundle.getParcelable(key) as LocationParcelable?
    }

    override fun parseValue(value: String): LocationParcelable {
        return Json.decodeFromString(Uri.decode(value))
    }
}