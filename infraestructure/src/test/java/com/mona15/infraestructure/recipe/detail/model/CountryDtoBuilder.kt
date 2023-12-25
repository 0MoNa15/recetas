package com.mona15.infraestructure.recipe.detail.model

import com.mona15.infraestructure.country.dto.CountryDto

class CountryDtoBuilder {
    private var name: String = "Colombia"
    private var flag: String = "https://i.ibb.co/7S1W7c7/bandera-colombia.png"

    fun withName(name: String): CountryDtoBuilder = apply { this.name = name }

    fun withFlag(flag: String): CountryDtoBuilder = apply { this.flag = flag }

    fun build(): CountryDto {
        return CountryDto(name, flag)
    }
}
