package com.mona15.infraestructure.recipe.detail.model

import com.mona15.infraestructure.recipe.detail.dto.IngredientDto
import com.mona15.infraestructure.recipe.detail.dto.LocationDto
import com.mona15.infraestructure.recipe.detail.dto.MacronutrientDto
import com.mona15.infraestructure.recipe.detail.dto.ResponseRecipeDetailDto

class ResponseRecipeDetailDtoBuilder {

    private var id: String = "COL001"
    private var name: String = "Ajiaco"
    private var description: String = "Sopa colombiana espesa y nutritiva."
    private var image: String = "https://i.ibb.co/zGcGtwh/ajiaco.jpg"

    private var ingredients: List<IngredientDto> = listOf(
        IngredientDtoBuilder().build(),
        IngredientDtoBuilder().withName("Pollo")
            .withAmount(300)
            .withPresentation("gramos")
            .build()
    )
    private var macronutrients: MacronutrientDto = MacronutrientDtoBuilder().build()
    private var location: LocationDto = LocationDtoBuilder().build()
    private var preparationTimeMinutes: Int = 40
    private var slices: Int = 4
    private var difficulty: String = "Media"
    private var instructions: List<String> = listOf(
        "1. Lavar y pelar las papas criollas.",
        "2. Cocinar el pollo en una olla grande con agua.",
        "3. Agregar las papas criollas, la mazorca, el caldo, y otros ingredientes.",
        "4. Cocinar hasta que las papas estén suaves y el caldo espese.",
        "5. Servir caliente y agregar alcaparras y crema al gusto."
    )

    fun withId(id: String): ResponseRecipeDetailDtoBuilder = apply { this.id = id }

    fun withName(name: String): ResponseRecipeDetailDtoBuilder = apply { this.name = name }

    fun withDescription(description: String): ResponseRecipeDetailDtoBuilder = apply { this.description = description }

    fun withImage(image: String): ResponseRecipeDetailDtoBuilder = apply { this.image = image }

    fun withIngredients(ingredients: List<IngredientDto>): ResponseRecipeDetailDtoBuilder =
        apply { this.ingredients = ingredients }

    fun withMacronutrients(macronutrients: MacronutrientDto): ResponseRecipeDetailDtoBuilder =
        apply { this.macronutrients = macronutrients }

    fun withLocation(location: LocationDto): ResponseRecipeDetailDtoBuilder = apply { this.location = location }

    fun withPreparationTimeMinutes(preparationTimeMinutes: Int): ResponseRecipeDetailDtoBuilder =
        apply { this.preparationTimeMinutes = preparationTimeMinutes }

    fun withSlices(slices: Int): ResponseRecipeDetailDtoBuilder = apply { this.slices = slices }

    fun withDifficulty(difficulty: String): ResponseRecipeDetailDtoBuilder = apply { this.difficulty = difficulty }

    fun withInstructions(instructions: List<String>): ResponseRecipeDetailDtoBuilder =
        apply { this.instructions = instructions }

    fun build(): ResponseRecipeDetailDto {
        return ResponseRecipeDetailDto(
            id, name, description, image, ingredients, macronutrients, location,
            preparationTimeMinutes, slices, difficulty, instructions
        )
    }
}
