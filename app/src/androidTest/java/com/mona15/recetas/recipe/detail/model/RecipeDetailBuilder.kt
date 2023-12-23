package com.mona15.recetas.recipe.detail.model

import com.mona15.domain.country.model.Country
import com.mona15.domain.recipe.detail.model.Ingredient
import com.mona15.domain.recipe.detail.model.Location
import com.mona15.domain.recipe.detail.model.Macronutrient
import com.mona15.domain.recipe.detail.model.RecipeDetail

class RecipeDetailBuilder {
    private var id: String = "COL001"
    private var name: String = "Ajiaco"
    private var description: String = "Sopa colombiana espesa y nutritiva."
    private var image: String = "https://ibb.co/wMHM21N"
    private var ingredients: List<Ingredient> = listOf(
        Ingredient("Papa criolla", 200, "gramos"),
        Ingredient("Pollo", 300, "gramos"),
        Ingredient("Mazorca", 1, "unidad"),
        Ingredient("Caldo de pollo", 1, "litro"),
        Ingredient("Alcaparras", 50, "gramos"),
        Ingredient("Crema de leche", 100, "mililitros")
    )
    private var macronutrients: Macronutrient = Macronutrient(400, 25, 10, 50)
    private var location: Location = Location(4.6097, -74.0817, "Bogotá", Country("Colombia", "https://i.ibb.co/7S1W7c7/bandera-colombia.png"))
    private var preparationTimeMinutes: Int = 40
    private var slices: Int = 4
    private var difficulty: String = "Media"
    private var instructions: List<String> = listOf(
        "1. Lavar y pelar las papas criollas.",
        "2. Cocinar el pollo en una olla grande con agua.",
        "3. Agregar las papas criollas, la mazorca, el caldo, y otros ingredientes.",
        "4. Cocinar hasta que las papas estén suaves y el caldo espese.",
        "5. Servir caliente y agregar alcaparras y crema al gusto."
    )

    fun withId(id: String): RecipeDetailBuilder = apply { this.id = id }

    fun withName(name: String): RecipeDetailBuilder = apply { this.name = name }

    fun withDescription(description: String): RecipeDetailBuilder = apply { this.description = description }

    fun withImage(image: String): RecipeDetailBuilder = apply { this.image = image }

    fun withIngredients(ingredients: List<Ingredient>): RecipeDetailBuilder = apply { this.ingredients = ingredients }

    fun withMacronutrients(macronutrients: Macronutrient): RecipeDetailBuilder = apply { this.macronutrients = macronutrients }

    fun withLocation(location: Location): RecipeDetailBuilder = apply { this.location = location }

    fun withPreparationTimeMinutes(preparationTimeMinutes: Int): RecipeDetailBuilder =
        apply { this.preparationTimeMinutes = preparationTimeMinutes }

    fun withSlices(slices: Int): RecipeDetailBuilder = apply { this.slices = slices }

    fun withDifficulty(difficulty: String): RecipeDetailBuilder = apply { this.difficulty = difficulty }

    fun withInstructions(instructions: List<String>): RecipeDetailBuilder = apply { this.instructions = instructions }

    fun build(): RecipeDetail {
        return RecipeDetail(
            id, name, description, image, ingredients, macronutrients, location,
            preparationTimeMinutes, slices, difficulty, instructions
        )
    }
}