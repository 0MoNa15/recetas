package com.mona15.infraestructure.recipe.detail.model

import com.mona15.domain.recipe.detail.model.Macronutrient

class MacronutrientBuilder {
    private var calories: Int = 400
    private var proteins: Int = 25
    private var fats: Int = 10
    private var carbohydrates: Int = 50

    fun withCalories(calories: Int): MacronutrientBuilder = apply { this.calories = calories }

    fun withProteins(proteins: Int): MacronutrientBuilder = apply { this.proteins = proteins }

    fun withFats(fats: Int): MacronutrientBuilder = apply { this.fats = fats }

    fun withCarbohydrates(carbohydrates: Int): MacronutrientBuilder =
        apply { this.carbohydrates = carbohydrates }

    fun build(): Macronutrient {
        return Macronutrient(calories, proteins, fats, carbohydrates)
    }
}
