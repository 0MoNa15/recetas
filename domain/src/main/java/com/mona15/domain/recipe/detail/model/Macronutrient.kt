package com.mona15.domain.recipe.detail.model

class Macronutrient (
    val calories: Int,
    val proteins: Int,
    val fats: Int,
    val carbohydrates: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Macronutrient) return false

        return calories == other.calories &&
                proteins == other.proteins &&
                fats == other.fats &&
                carbohydrates == other.carbohydrates
    }

    override fun hashCode(): Int {
        var result = calories
        result = 31 * result + proteins
        result = 31 * result + fats
        result = 31 * result + carbohydrates
        return result
    }
}