package com.mona15.domain.recipe.list.model

class Recipe(
    val id: String = "",
    val name: String = "",
    val ingredients: List<String> = emptyList(),
    val urlImage: String = ""
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Recipe) return false

        return id == other.id &&
                name == other.name &&
                ingredients == other.ingredients &&
                urlImage == other.urlImage
    }

    override fun hashCode(): Int {
        return id.hashCode() +
                name.hashCode() +
                ingredients.hashCode() +
                urlImage.hashCode()
    }
}