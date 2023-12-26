package com.mona15.recetas.recipe.detail

import com.mona15.domain.country.model.Country
import com.mona15.domain.recipe.detail.model.Ingredient
import com.mona15.domain.recipe.detail.model.Location
import com.mona15.domain.recipe.detail.model.Macronutrient
import com.mona15.domain.recipe.detail.model.RecipeDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Builder {
    companion object {
        fun getFlowRecipeDetail(): Flow<RecipeDetail> {
            return flow { emit(getRecipeDetail()) }
        }

        fun getRecipeDetail(): RecipeDetail {
            return RecipeDetail(
                id = "COL001",
                name = "Ajiaco",
                description = "Sopa colombiana espesa y nutritiva.",
                image = "https://ibb.co/wMHM21N",
                ingredients = listOf(
                    Ingredient("Papa criolla", 200, "gramos"),
                    Ingredient("Pollo", 300, "gramos"),
                    Ingredient("Mazorca", 1, "unidad"),
                    Ingredient("Caldo de pollo", 1, "litro"),
                    Ingredient("Alcaparras", 50, "gramos"),
                    Ingredient("Crema de leche", 100, "mililitros")
                ),
                macronutrients = Macronutrient(400, 25, 10, 50),
                location = Location(4.6097, -74.0817, "Bogotá", Country("Colombia", "https://i.ibb.co/7S1W7c7/bandera-colombia.png")),
                preparationTimeMinutes = 40,
                slices = 4,
                difficulty = "Media",
                instructions = listOf(
                    "1. Lavar y pelar las papas criollas.",
                    "2. Cocinar el pollo en una olla grande con agua.",
                    "3. Agregar las papas criollas, la mazorca, el caldo, y otros ingredientes.",
                    "4. Cocinar hasta que las papas estén suaves y el caldo espese.",
                    "5. Servir caliente y agregar alcaparras y crema al gusto."
                )
            )
        }
    }
}