package com.example.recipeapp.ui.viewmodel

import com.example.recipeapp.data.model.Meal

sealed class RecipeViewState{
    object Loading: RecipeViewState()
    data class Success(val recipes: List<Meal>): RecipeViewState()
    data class Error(val message: String): RecipeViewState()
}
