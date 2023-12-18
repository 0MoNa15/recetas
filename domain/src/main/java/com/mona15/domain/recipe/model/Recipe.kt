package com.mona15.domain.recipe.model

class Recipe(
    val id: String = "",
    val name: String = "",
    val ingredients: List<String> = emptyList(),
    val urlImage: String = ""
)