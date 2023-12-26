package com.mona15.infraestructure.recipe.detail.model

import com.mona15.domain.country.model.Country
import com.mona15.domain.recipe.detail.model.Location

class LocationBuilder {
    private var latitude: Double = 4.6097
    private var longitude: Double = -74.0817
    private var city: String = "Bogotá"
    private var country: Country = CountryBuilder().build()

    fun withLatitude(latitude: Double): LocationBuilder = apply { this.latitude = latitude }

    fun withLongitude(longitude: Double): LocationBuilder = apply { this.longitude = longitude }

    fun withCity(city: String): LocationBuilder = apply { this.city = city }

    fun withCountry(country: Country): LocationBuilder = apply { this.country = country }

    fun build(): Location {
        return Location(latitude, longitude, city, country)
    }
}
