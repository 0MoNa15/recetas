package com.mona15.infraestructure.country.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryDto(
    @SerializedName("nombre") val name: String,
    @SerializedName("bandera") val flag: String,
) : Parcelable