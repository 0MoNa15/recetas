package com.mona15.infraestructure.recipe.list.model

import com.mona15.infraestructure.recipe.list.dto.RecipeDto

class RecipeDtoBuilder {
    private var id: String = "COL001"
    private var name: String = "Ajiaco"
    private var ingredients: List<String> = listOf(
        "Papa criolla",
        "Pollo",
        "Mazorca",
        "Caldo de pollo",
        "Alcaparras",
        "Crema de leche"
    )
    private var urlImage: String = "https://i.ibb.co/zGcGtwh/ajiaco.jpg"

    fun withId(id: String): RecipeDtoBuilder = apply { this.id = id }

    fun withName(name: String): RecipeDtoBuilder = apply { this.name = name }

    fun withIngredients(ingredients: List<String>): RecipeDtoBuilder = apply { this.ingredients = ingredients }

    fun withUrlImage(urlImage: String): RecipeDtoBuilder = apply { this.urlImage = urlImage }

    fun build(): RecipeDto = RecipeDto(id, name, ingredients, urlImage)
}