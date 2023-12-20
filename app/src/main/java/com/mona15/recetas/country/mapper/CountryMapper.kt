package com.mona15.recetas.country.mapper

import com.mona15.domain.country.model.Country
import com.mona15.recetas.country.model.CountryParcelable


object CountryMapper {
    fun fromDomainToParcelable(country: Country): CountryParcelable =
        CountryParcelable(country.name, country.flag)

    fun fromParcelableToDomain(countryParcelable: CountryParcelable): Country =
        Country(countryParcelable.name, countryParcelable.flag)
}