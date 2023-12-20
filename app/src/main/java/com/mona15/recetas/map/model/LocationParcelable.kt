package com.mona15.recetas.map.model

import android.os.Parcelable
import com.mona15.recetas.country.model.CountryParcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LocationParcelable(
    val latitude: Double,
    val longitude: Double,
    val city: String,
    val countryParcelable: CountryParcelable
) : Parcelable
