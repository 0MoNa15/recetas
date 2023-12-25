package com.mona15.domain.recipe.detail.model

class Ingredient(
    val name: String,
    val amount: Int,
    val presentation: String)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Ingredient) return false

        return name == other.name &&
                amount == other.amount &&
                presentation == other.presentation
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + amount
        result = 31 * result + presentation.hashCode()
        return result
    }
}