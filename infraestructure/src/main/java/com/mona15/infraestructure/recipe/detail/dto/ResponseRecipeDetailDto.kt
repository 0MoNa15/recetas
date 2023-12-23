package com.mona15.infraestructure.recipe.detail.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseRecipeDetailDto(
    @SerializedName("id") val id: String,
    @SerializedName("nombre") val name: String,
    @SerializedName("descripcion") val description: String,
    @SerializedName("imagen") val image: String,
    @SerializedName("ingredientes") val ingredients: List<IngredientDto>,
    @SerializedName("macronutrientes") val macronutrients: MacronutrientDto,
    @SerializedName("ubicacion") val location: LocationDto,
    @SerializedName("tiempo_preparacion_minutos") val preparationTimeMinutes: Int,
    @SerializedName("porciones") val slices: Int,
    @SerializedName("dificultad") val difficulty: String,
    @SerializedName("instrucciones") val instructions: List<String>
) : Parcelable
