package com.mona15.infraestructure.recipe.detail.repository

import com.mona15.infraestructure.anticorruption.Mapper
import com.mona15.infraestructure.recipe.detail.api.RecipeDetailApi
import com.mona15.infraestructure.recipe.list.repository.RecipeListRetrofitRepository
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RecipeDetailRetrofitRepositoryTest {

    @Mock
    private lateinit var recipeDetailApi: RecipeDetailApi

    @Mock
    private lateinit var mapper: Mapper

    @InjectMocks
    private lateinit var recipeDetailRepository: RecipeListRetrofitRepository
}