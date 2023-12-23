package com.mona15.infraestructure.recipe.detail.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MacronutrientDto(
    @SerializedName("calorias") val calories: Int,
    @SerializedName("proteinas") val proteins: Int,
    @SerializedName("grasas") val fats: Int,
    @SerializedName("carbohidratos") val carbohydrates: Int
) : Parcelable