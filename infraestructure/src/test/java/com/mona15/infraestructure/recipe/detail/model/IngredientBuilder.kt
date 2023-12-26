package com.mona15.infraestructure.recipe.detail.model

import com.mona15.domain.recipe.detail.model.Ingredient

class IngredientBuilder {
    private var name: String = "Papa criolla"
    private var amount: Int = 200
    private var presentation: String = "gramos"

    fun withName(name: String): IngredientBuilder = apply { this.name = name }

    fun withAmount(amount: Int): IngredientBuilder = apply { this.amount = amount }

    fun withPresentation(presentation: String): IngredientBuilder = apply { this.presentation = presentation }

    fun build(): Ingredient {
        return Ingredient(name, amount, presentation)
    }
}
