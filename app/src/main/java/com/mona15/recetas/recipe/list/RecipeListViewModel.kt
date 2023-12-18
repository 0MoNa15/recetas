package com.mona15.recetas.recipe.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mona15.domain.recipe.usecases.GetAllRecipesUseCase
import com.mona15.domain.recipe.usecases.GetRecipesByCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val getAllRecipesUseCase: GetAllRecipesUseCase,
    private val getRecipesByCountryUseCase: GetRecipesByCountryUseCase
) : ViewModel() {

    private val loading = MutableStateFlow(RecipeListUiState().loading)
    private val success = MutableStateFlow(RecipeListUiState().success)
    private val error = MutableStateFlow(RecipeListUiState().error)
    private val message = MutableStateFlow(RecipeListUiState().message)

    private val _uiState = MutableStateFlow(RecipeListUiState())
    val uiState: StateFlow<RecipeListUiState> get() = _uiState
    
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