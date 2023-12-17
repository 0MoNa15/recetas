package com.mona15.domain.recipe.exceptions

private const val TECHNICAL_EXCEPTION_CODE = 500

class TechnicalException (val codeMessage: Int = TECHNICAL_EXCEPTION_CODE) : Exception(codeMessage.toString())