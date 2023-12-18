package com.mona15.recetas.country

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mona15.domain.country.usecases.GetAllCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {

    private val loading = MutableStateFlow(CountryUiState().loading)
    private val success = MutableStateFlow(CountryUiState().success)
    private val error = MutableStateFlow(CountryUiState().error)
    private val message = MutableStateFlow(CountryUiState().message)

    private val _uiState = MutableStateFlow(CountryUiState())
    val uiState: StateFlow<CountryUiState> get() = _uiState

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