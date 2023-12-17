package com.mona15.domain.recipe.model

class RecipeDetail(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val ingredients: List<Ingredient>,
    val macronutrients: Macronutrient,
    val location: Location,
    val preparationTimeMinutes: Int,
    val slices: Int,
    val difficulty: String,
    val instructions: List<String>)
{

    init {
        validations()
    }

    private fun validations() {
        validarId()
        validarNombre()
        validarImagen()
        validarIngredientes()
    }

    private fun validarId() {
        require(id.isNotEmpty()) { "El Id no puede estar vacío" }
    }

    private fun validarNombre() {
        require(name.isNotEmpty()) { "El nombre no puede estar vacío" }
    }
    private fun validarImagen() {
        require(image.isNotEmpty()) { "La URL de la imagen no puede estar vacía" }
    }

    private fun validarIngredientes() {
        require(ingredients.isNotEmpty()) { "La lista de ingredientes no puede estar vacía" }
    }
}
