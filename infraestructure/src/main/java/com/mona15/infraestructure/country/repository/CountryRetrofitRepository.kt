package com.mona15.infraestructure.country.repository

import com.mona15.infraestructure.country.api.CountryApi

class CountryRetrofitRepository(private val countryApi: CountryApi) : CountryRepository {
}