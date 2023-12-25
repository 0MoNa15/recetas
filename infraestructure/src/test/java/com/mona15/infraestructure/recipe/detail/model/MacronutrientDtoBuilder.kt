package com.mona15.infraestructure.recipe.detail.model

import com.mona15.infraestructure.recipe.detail.dto.MacronutrientDto

class MacronutrientDtoBuilder {
    private var calories: Int = 400
    private var proteins: Int = 25
    private var fats: Int = 10
    private var carbohydrates: Int = 50

    fun withCalories(calories: Int): MacronutrientDtoBuilder = apply { this.calories = calories }

    fun withProteins(proteins: Int): MacronutrientDtoBuilder = apply { this.proteins = proteins }

    fun withFats(fats: Int): MacronutrientDtoBuilder = apply { this.fats = fats }

    fun withCarbohydrates(carbohydrates: Int): MacronutrientDtoBuilder = apply { this.carbohydrates = carbohydrates }

    fun build(): MacronutrientDto {
        return MacronutrientDto(calories, proteins, fats, carbohydrates)
    }
}

