package com.mona15.domain.recipe.detail.model

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
    val instructions: List<String>
) {
    init {
        validations()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RecipeDetail) return false

        return id == other.id &&
                name == other.name &&
                description == other.description &&
                image == other.image &&
                ingredients == other.ingredients &&
                macronutrients == other.macronutrients &&
                location == other.location &&
                preparationTimeMinutes == other.preparationTimeMinutes &&
                slices == other.slices &&
                difficulty == other.difficulty &&
                instructions == other.instructions
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + image.hashCode()
        result = 31 * result + ingredients.hashCode()
        result = 31 * result + macronutrients.hashCode()
        result = 31 * result + location.hashCode()
        result = 31 * result + preparationTimeMinutes
        result = 31 * result + slices
        result = 31 * result + difficulty.hashCode()
        result = 31 * result + instructions.hashCode()
        return result
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
