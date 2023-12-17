package com.mona15.infraestructure.country.repository

import com.mona15.domain.country.exceptions.NoDataCountryException
import com.mona15.domain.country.model.Country
import com.mona15.domain.country.repository.CountryRepository
import com.mona15.infraestructure.anticorruption.Mapper
import com.mona15.infraestructure.country.api.CountryApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CountryRetrofitRepository(private val countryApi: CountryApi) : CountryRepository {
    override fun getCountries(): Flow<List<Country>> {
        return flow { emit(countryApi.getAllCountries()) }
            .catch {
                throw NoDataCountryException()
            }.map {
                Mapper.convert(it.countries)
            }
    }
}