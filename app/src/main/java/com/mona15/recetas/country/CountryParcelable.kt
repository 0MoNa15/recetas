package com.mona15.recetas.country

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class CountryParcelable(
    val name: String,
    val flag: String
) : Parcelable