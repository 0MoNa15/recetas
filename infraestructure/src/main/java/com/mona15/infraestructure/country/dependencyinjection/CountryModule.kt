package com.mona15.infraestructure.country.dependencyinjection

import com.mona15.domain.country.repository.CountryRepository
import com.mona15.infraestructure.country.api.CountryApi
import com.mona15.infraestructure.country.repository.CountryRetrofitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CountryModule {

    @Provides
    fun provideCountryRepository(countryApi: CountryApi): CountryRepository =
        CountryRetrofitRepository(countryApi)
}