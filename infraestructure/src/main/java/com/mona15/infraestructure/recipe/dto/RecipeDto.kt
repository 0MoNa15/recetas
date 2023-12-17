package com.mona15.infraestructure.recipe.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeDto(
    @SerializedName("id") val id: String,
    @SerializedName("nombre") val name: String,
    @SerializedName("ingredientes") val ingredients: List<String>,
    @SerializedName("imagen") val urlImage: String
) : Parcelable
