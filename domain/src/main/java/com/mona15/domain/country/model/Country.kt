package com.mona15.domain.country.model

class Country(
    val name: String,
    val flag: String)
{
    init {
        validations()
    }

    private fun validations() {
        //validateName()
        //validateFlag()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Country) return false

        return name == other.name &&
                flag == other.flag
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + flag.hashCode()
        return result
    }
}