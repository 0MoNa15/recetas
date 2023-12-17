package com.mona15.infraestructure.recipe.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseRecipesDto(
    @SerializedName("recetas") val recetas: List<RecipeDto>
) : Parcelable
