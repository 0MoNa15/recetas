package com.mona15.domain.recipe.list.model

class RecipeBuilder {
    companion object {
        fun getRecipe(name: String): Recipe {
            return if (name == "Ajiaco") {
                Recipe(
                    "COL001",
                    "Ajiaco",
                    listOf(
                        "Papa criolla",
                        "Pollo",
                        "Mazorca",
                        "Caldo de pollo",
                        "Alcaparras",
                        "Crema de leche"
                    ),
                    "https://i.ibb.co/zGcGtwh/ajiaco.jpg"
                )
            } else {
                Recipe(
                    "REC002",
                    "Causa Rellena",
                    listOf(
                        "Papas amarillas",
                        "Ají amarillo",
                        "Limón",
                        "Pollo",
                        "Mayonesa",
                        "Aguacate"
                    ),
                    "https://i.ibb.co/3W319RZ/causa-rellena.jpg"
                )
            }
        }
    }
}

