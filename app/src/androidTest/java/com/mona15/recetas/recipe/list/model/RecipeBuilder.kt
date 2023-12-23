package com.mona15.recetas.recipe.list.model

import com.mona15.domain.recipe.list.model.Recipe

class RecipeBuilder {
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

    fun withId(id: String): RecipeBuilder = apply { this.id = id }

    fun withName(name: String): RecipeBuilder = apply { this.name = name }

    fun withIngredients(ingredients: List<String>): RecipeBuilder = apply { this.ingredients = ingredients }

    fun withUrlImage(urlImage: String): RecipeBuilder = apply { this.urlImage = urlImage }

    fun build(): Recipe = Recipe(id, name, ingredients, urlImage)
}
