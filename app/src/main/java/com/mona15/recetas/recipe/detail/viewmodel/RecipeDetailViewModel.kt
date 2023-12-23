package com.mona15.recetas.recipe.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mona15.domain.recipe.exceptions.NoDataRecipeException
import com.mona15.domain.recipe.detail.usecase.GetRecipeDetailUseCase
import com.mona15.recetas.recipe.detail.view.state.RecipeDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val getRecipeDetailUseCase: GetRecipeDetailUseCase
) : ViewModel() {

    private val loading = MutableStateFlow(RecipeDetailUiState().loading)
    private val success = MutableStateFlow(RecipeDetailUiState().success)
    private val error = MutableStateFlow(RecipeDetailUiState().error)
    private val message = MutableStateFlow(RecipeDetailUiState().message)

    private val _uiState = MutableStateFlow(RecipeDetailUiState())
    val uiState: StateFlow<RecipeDetailUiState> get() = _uiState

    init {
        viewModelScope.launch {
            combine(
                loading,
                success,
                error,
                message
            ) { loading, success, error, message ->
                RecipeDetailUiState(loading, success, error, message)
            }.catch { throwable ->
                throw throwable
            }.collect {
                _uiState.value = it
            }
        }
    }

    fun getRecipe(id: String?) {
        viewModelScope.launch {
            loading.value = true
            try {
                getRecipeDetailUseCase.invoke(id).collect { recipe ->
                    success.value = recipe
                    loading.value = false
                }
            } catch (e: Exception) {
                loading.value = false
                error.value = true
                if(e is NoDataRecipeException) message.value = e.message.toString()
            }
        }
    }
}