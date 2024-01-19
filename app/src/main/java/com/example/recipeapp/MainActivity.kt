package com.example.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipeapp.ui.screens.HomeScreen
import com.example.recipeapp.ui.theme.RecipeAppTheme
import com.example.recipeapp.ui.viewmodel.RecipeViewModel

class MainActivity : ComponentActivity() {
    private val recipeViewModel:RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme {

                HomeScreen(recipeViewModel = recipeViewModel)
            }
        }
    }
}
