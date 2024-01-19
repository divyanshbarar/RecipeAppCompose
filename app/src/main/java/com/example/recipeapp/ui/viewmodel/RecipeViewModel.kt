package com.example.recipeapp.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.network.MealApi
import com.example.recipeapp.data.network.RetroFithelper
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {
    val api = RetroFithelper.getInstance().create(MealApi::class.java)
    private val _state = mutableStateOf<RecipeViewState>(RecipeViewState.Loading)
    val state: State<RecipeViewState> = _state

    fun processIntent(intent: RecipeViewIntent) {
        when(intent) {
            is RecipeViewIntent.LoadRandomRecipe -> loadRandomRecipe()
            is RecipeViewIntent.SearchRecipes -> searchRecipe(intent.query)
        }
    }

    private fun searchRecipe(query: String) {
        viewModelScope.launch {
            _state.value = RecipeViewState.Loading
            try {
                Log.d("calling", "viewModel")
                val response = api.getSearchRecipe(query)
                Log.d("calling", "api res $response")
                if (response.meals!=null) {
                    _state.value = RecipeViewState.Success(response.meals)
                } else {
                    _state.value = RecipeViewState.Error("Error Fetching")
                }
            } catch(e: Exception) {
                _state.value = RecipeViewState.Error("Error fetching recipe: ${e.message}")
            }
        }
    }

    private fun loadRandomRecipe() {
        viewModelScope.launch {
            _state.value = RecipeViewState.Loading
            try {
                Log.d("calling", "viewModel")
                val response = api.getRandomRecipe()
                Log.d("calling", "api res $response")
                if (response.meals!=null) {
                    _state.value = RecipeViewState.Success(response.meals)
                } else {
                    _state.value = RecipeViewState.Error("Error Fetching")
                }
            } catch(e: Exception) {
                _state.value = RecipeViewState.Error("Error fetching recipe: ${e.message}")
            }
        }
    }


}