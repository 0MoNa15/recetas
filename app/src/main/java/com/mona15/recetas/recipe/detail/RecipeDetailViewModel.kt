package com.mona15.recetas.recipe.detail

import androidx.lifecycle.ViewModel
import com.mona15.domain.country.usecases.GetAllCountriesUseCase
import com.mona15.domain.recipe.usecases.GetRecipeDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val getRecipeDetailUseCase: GetRecipeDetailUseCase
) : ViewModel() {

}