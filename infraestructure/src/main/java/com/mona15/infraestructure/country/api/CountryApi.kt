package com.mona15.infraestructure.country.api

import com.mona15.infraestructure.country.dto.ResponseCountriesDto
import retrofit2.http.GET

private const val COUNTRY_PATH = "/paises"

interface CountryApi {

    @GET(COUNTRY_PATH)
    suspend fun getAllCountries(): ResponseCountriesDto
}