package com.mona15.infraestructure.recipe.detail.model

import com.mona15.infraestructure.country.dto.CountryDto
import com.mona15.infraestructure.recipe.detail.dto.LocationDto

class LocationDtoBuilder {
    private var latitude: Double = 4.6097
    private var longitude: Double = -74.0817
    private var city: String = "Bogotá"
    private var country: CountryDto = CountryDtoBuilder().build()

    fun withLatitude(latitude: Double): LocationDtoBuilder = apply { this.latitude = latitude }

    fun withLongitude(longitude: Double): LocationDtoBuilder = apply { this.longitude = longitude }

    fun withCity(city: String): LocationDtoBuilder = apply { this.city = city }

    fun withCountry(country: CountryDto): LocationDtoBuilder = apply { this.country = country }

    fun build(): LocationDto {
        return LocationDto(latitude, longitude, city, country)
    }
}

