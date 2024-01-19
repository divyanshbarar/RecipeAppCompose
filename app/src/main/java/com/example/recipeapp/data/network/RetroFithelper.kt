package com.example.recipeapp.data.network

import android.util.Log
import com.example.recipeapp.data.model.Meal
import com.example.recipeapp.data.model.RecipeResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetroFithelper {

    fun getInstance(): Retrofit {

        val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

    }

//    private val apiClient = HttpClient(CIO){
//        install(ContentNegotiation) {
//            json()
//        }
//    }
//
//    suspend fun getRandomRecipe(): List<Meal> {
//        Log.d("calling","api")
//        val url = "https://www.themealdb.com/api/json/v1/1/random.php"
//
//        Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build()
//        val response = apiClient.get(url).body() as RecipeResponse
//        Log.d("calling","apiresponse")
//        return response.meals
//    }
//
//    suspend fun getSearchedRecipe(query: String): List<Meal> {
//        Log.d("calling","api")
//        val url = "https://www.themealdb.com/api/json/v1/1/search.php?s=$query"
//        val response = apiClient.get(url).body() as RecipeResponse
//        Log.d("calling","api")
//        return response.meals
//    }


}