package com.mona15.domain.country.model

class Country(val name: String, val flag: String) {

    init {
        validations()
    }

    private fun validations() {
        //validateName()
        //validateFlag()
    }
}