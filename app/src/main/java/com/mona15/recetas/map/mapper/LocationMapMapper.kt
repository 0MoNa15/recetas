package com.mona15.recetas.map.mapper

import com.mona15.domain.recipe.model.Location
import com.mona15.recetas.country.mapper.CountryMapper
import com.mona15.recetas.map.model.LocationParcelable

internal object LocationMapMapper {
    fun fromDomainToParcelable(location: Location): LocationParcelable =
        LocationParcelable(
            location.latitude,
            location.longitude,
            location.city,
            CountryMapper.fromDomainToParcelable(location.country))

    fun fromParcelableToDomain(locationParcelable: LocationParcelable): Location =
        Location(
            locationParcelable.latitude,
            locationParcelable.longitude,
            locationParcelable.city,
            CountryMapper.fromParcelableToDomain(locationParcelable.countryParcelable))
}