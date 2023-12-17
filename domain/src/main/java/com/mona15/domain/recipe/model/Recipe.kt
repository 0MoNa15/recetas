package com.mona15.domain.recipe.model

class Recipe(
    val id: String,
    val name: String,
    val ingredients: List<String>,
    val urlImage: String)
{

    init {
        validations()
    }

    private fun validations() {
        validateId()
        validateName()
        validateIngredients()
        validateUrlImage()
    }

    private fun validateId() {
        require(id.isNotEmpty()) { "El id no puede estar vacío" }
    }

    private fun validateName() {
        require(name.isNotEmpty()) { "El nombre no puede estar vacío" }
    }

    private fun validateIngredients() {
        require(ingredients.isNotEmpty()) { "Los ingredientes no pueden estar vacíos" }
    }

    private fun validateUrlImage() {
        require(urlImage.isNotEmpty()) { "La Url de la imágen no puede estar vacía" }
    }
}