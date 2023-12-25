package com.mona15.infraestructure.recipe.detail.model

import com.mona15.infraestructure.recipe.detail.dto.IngredientDto

class IngredientDtoBuilder {
    private var name: String = "Papa criolla"
    private var amount: Int = 200
    private var presentation: String = "gramos"

    fun withName(name: String): IngredientDtoBuilder = apply { this.name = name }

    fun withAmount(amount: Int): IngredientDtoBuilder = apply { this.amount = amount }

    fun withPresentation(presentation: String): IngredientDtoBuilder = apply { this.presentation = presentation }

    fun build(): IngredientDto {
        return IngredientDto(name, amount, presentation)
    }
}

