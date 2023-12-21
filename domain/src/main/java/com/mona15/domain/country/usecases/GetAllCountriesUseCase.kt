package com.mona15.domain.country.usecases

import com.mona15.domain.country.model.Country
import com.mona15.domain.country.repository.CountryRepository
import kotlinx.coroutines.flow.Flow

class GetAllCountriesUseCase constructor(private val countryRepository: CountryRepository) {
    suspend operator fun invoke(): Flow<List<Country>> = countryRepository.getCountries()
}