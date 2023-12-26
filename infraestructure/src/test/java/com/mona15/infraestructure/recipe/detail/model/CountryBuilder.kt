package com.mona15.infraestructure.recipe.detail.model

import com.mona15.domain.country.model.Country

class CountryBuilder {
    private var name: String = "Colombia"
    private var flag: String = "https://i.ibb.co/7S1W7c7/bandera-colombia.png"

    fun withName(name: String): CountryBuilder = apply { this.name = name }

    fun withFlag(flag: String): CountryBuilder = apply { this.flag = flag }

    fun build(): Country {
        return Country(name, flag)
    }
}
