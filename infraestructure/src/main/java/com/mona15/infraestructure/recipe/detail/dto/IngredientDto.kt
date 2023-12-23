package com.mona15.infraestructure.recipe.detail.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class IngredientDto(
    @SerializedName("nombre") val name: String,
    @SerializedName("cantidad") val amount: Int,
    @SerializedName("presentacion") val presentation: String,
) : Parcelable