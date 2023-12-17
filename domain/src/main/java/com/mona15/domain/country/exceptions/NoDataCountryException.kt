package com.mona15.domain.country.exceptions

private const val NO_DATA_COUNTRY_EXCEPTION_CODE = 404

class NoDataCountryException(val codeMessage: Int = NO_DATA_COUNTRY_EXCEPTION_CODE) : CountryException(codeMessage.toString())
