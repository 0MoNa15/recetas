package com.mona15.recetas

open class BaseUiState (
    var loading: Boolean = false,
    var error: Boolean = false,
    var message: String = ""
)