package com.mona15.domain.recipe.detail.model

import com.mona15.domain.country.model.Country
import com.mona15.domain.recipe.detail.model.Ingredient
import com.mona15.domain.recipe.detail.model.Location
import com.mona15.domain.recipe.detail.model.Macronutrient
import com.mona15.domain.recipe.detail.model.RecipeDetail

class RecipeDetailBuilder {

    companion object {
        fun getRecipe(name: String): RecipeDetail {
            return if (name == "Ajiaco") {
                RecipeDetail(
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
                    location = Location(4.6097, -74.0817, "Bogotá", Country("Colombia", "https://ibb.co/wdzWDHD")),
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
            } else {
                RecipeDetail(
                    id = "REC002",
                    name = "Causa Rellena",
                    description = "Plato peruano a base de papa amarilla rellena de pollo y aguacate.",
                    image = "https://ibb.co/tcGBTLr",
                    ingredients = listOf(
                        Ingredient("Papas amarillas", 4, "unidades"),
                        Ingredient("Aji amarillo", 2, "unidades"),
                        Ingredient("Limón", 2, "unidades"),
                        Ingredient("Pollo desmenuzado", 200, "gramos"),
                        Ingredient("Aguacate", 1, "unidad"),
                        Ingredient("Mayonesa", 3, "cucharadas")
                    ),
                    macronutrients = Macronutrient(400, 15, 20, 30),
                    location = Location(-12.0464, -77.0428, "Lima", Country("Perú", "https://ibb.co/GQnWLX0")),
                    preparationTimeMinutes = 45,
                    slices = 3,
                    difficulty = "Media",
                    instructions = listOf(
                        "1. Cocinar las papas y hacer un puré.",
                        "2. Mezclar el puré con ají amarillo y limón.",
                        "3. Armar capas alternas de puré, pollo y aguacate.",
                        "4. Refrigerar y servir frío."
                    )
                )
            }
        }
    }
}