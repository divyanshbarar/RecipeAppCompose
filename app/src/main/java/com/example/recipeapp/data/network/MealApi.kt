package com.example.recipeapp.data.network

import com.example.recipeapp.data.model.Meal
import com.example.recipeapp.data.model.RecipeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET("random.php")
    suspend fun getRandomRecipe(): RecipeResponse

    @GET("search.php")
    suspend fun getSearchRecipe(
        @Query("s") query: String
    ): RecipeResponse


}