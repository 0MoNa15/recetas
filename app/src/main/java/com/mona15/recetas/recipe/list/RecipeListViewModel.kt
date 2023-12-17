package com.mona15.recetas.recipe.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mona15.domain.recipe.usecases.GetAllRecipesUseCase
import com.mona15.domain.recipe.usecases.GetRecipesByCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val getAllRecipesUseCase: GetAllRecipesUseCase,
    private val getRecipesByCountryUseCase: GetRecipesByCountryUseCase
) : ViewModel() {

    fun getAllRecipes() {
        viewModelScope.launch {
            try {
                getAllRecipesUseCase.invoke().collect { recipes -> }
            } catch (e: Exception) {
                println(e.message)
            }

        }
    }

    fun getRecipesByCountry(nameCountry: String) {
        viewModelScope.launch {
            try {
                getRecipesByCountryUseCase.invoke(nameCountry).collect { recipesByCountry -> }
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}