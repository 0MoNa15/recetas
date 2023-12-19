package com.mona15.recetas.country

import com.mona15.domain.country.model.Country

data class CountryUiState(
    var success: List<Country> = emptyList(),
    var loading: Boolean = false,
    var error: Boolean = false,
    var message: String = ""
)