package com.mona15.infraestructure.recipe.list.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseRecipesDto(
    @SerializedName("recetas") val recipes: List<RecipeDto>
) : Parcelable
