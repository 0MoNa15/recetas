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
