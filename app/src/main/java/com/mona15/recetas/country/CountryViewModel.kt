package com.mona15.recetas.country

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mona15.domain.country.usecases.GetAllCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {

    fun getCountries() {
        viewModelScope.launch {
            try {
                getAllCountriesUseCase.invoke().collect { countries ->
                    println(countries)

                }
            } catch (e: Exception) {
                println(e.message)
            }

        }
    }
}