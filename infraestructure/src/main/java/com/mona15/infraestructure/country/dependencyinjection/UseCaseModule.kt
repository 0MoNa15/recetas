package com.mona15.infraestructure.country.dependencyinjection

import com.mona15.domain.country.repository.CountryRepository
import com.mona15.domain.country.usecases.GetAllCountriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun getCountries (countryRepository: CountryRepository) : GetAllCountriesUseCase = GetAllCountriesUseCase(countryRepository)
}