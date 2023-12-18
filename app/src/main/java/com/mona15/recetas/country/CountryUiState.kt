package com.mona15.recetas.country

import com.mona15.domain.country.model.Country
import com.mona15.recetas.BaseUiState

data class CountryUiState(
    var success: List<Country> = emptyList()
) : BaseUiState()