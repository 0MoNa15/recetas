package com.mona15.domain.recipe.detail.model

import com.mona15.domain.country.model.Country

class Location(
    val latitude: Double,
    val longitude: Double,
    val city: String,
    val country: Country
) {

    init {
        validations()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Location) return false

        return latitude == other.latitude &&
                longitude == other.longitude &&
                city == other.city &&
                country == other.country
    }

    override fun hashCode(): Int {
        var result = latitude.hashCode()
        result = 31 * result + longitude.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + country.hashCode()
        return result
    }

    private fun validations() {
        validarLatitud()
        validarLongitud()
    }

    private fun validarLatitud() {
        require(latitude in -90.0..90.0) { "La latitud debe estar entre -90 y 90 grados" }
    }

    private fun validarLongitud() {
        require(longitude in -180.0..180.0) { "La longitud debe estar entre -180 y 180 grados" }
    }
}
