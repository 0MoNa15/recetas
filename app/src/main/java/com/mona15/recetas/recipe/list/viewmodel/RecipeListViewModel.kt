package com.mona15.recetas.recipe.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mona15.domain.recipe.exceptions.NoDataRecipeException
import com.mona15.domain.recipe.usecases.GetAllRecipesUseCase
import com.mona15.domain.recipe.usecases.GetRecipesByCountryUseCase
import com.mona15.recetas.recipe.list.view.RecipeListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
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

    init {
        viewModelScope.launch {
            combine(
                loading,
                success,
                error,
                message
            ) { loading, success, error, message ->
                RecipeListUiState(loading, success, error, message)
            }.catch { throwable ->
                throw throwable
            }.collect {
                _uiState.value = it
            }
        }
    }

    fun getAllRecipes() {
        viewModelScope.launch{
            loading.value = true
            try {
                getAllRecipesUseCase.invoke().collect { recipes ->
                    success.value = recipes
                    loading.value = false
                }
            } catch (e: Exception) {
                loading.value = false
                error.value = true
                if(e is NoDataRecipeException) message.value = e.message.toString()
                println(message.value)
            }
        }
    }

    fun getRecipesByCountry(nameCountry: String) {
        viewModelScope.launch{
            loading.value = true
            try {
                getRecipesByCountryUseCase.invoke(nameCountry).collect { recipesByCountry ->
                    success.value = recipesByCountry
                    loading.value = false
                }
            } catch (e: Exception) {
                loading.value = false
                error.value = true
                if(e is NoDataRecipeException) message.value = e.message.toString()
                println(message.value)
            }
        }
    }
}