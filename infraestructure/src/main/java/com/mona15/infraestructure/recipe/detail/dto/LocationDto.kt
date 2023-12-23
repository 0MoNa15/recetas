package com.mona15.infraestructure.recipe.detail.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.mona15.infraestructure.country.dto.CountryDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationDto(
    @SerializedName("latitud") val latitude: Double,
    @SerializedName("longitud") val longitude: Double,
    @SerializedName("ciudad") val city: String,
    @SerializedName("pais") val country: CountryDto
) : Parcelable