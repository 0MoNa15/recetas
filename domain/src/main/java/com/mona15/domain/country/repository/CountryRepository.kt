package com.mona15.domain.country.repository

import com.mona15.domain.country.model.Country
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    fun getCountries(): Flow<List<Country>>
}