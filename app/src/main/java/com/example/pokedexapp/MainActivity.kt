package com.example.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedexapp.pokemonlist.PokemonListScreen
import com.example.pokedexapp.ui.theme.PokedexAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "poke_list_screen") {
                    composable(route = "poke_list_screen") {
                        PokemonListScreen(navController = navController)
                    }
                    composable(
                        route = "details/{pokemonName}/{dominantColor}",
                        arguments =
                        listOf(
                            navArgument("pokemonName")
                            { type = NavType.StringType },
                            navArgument("dominantColor")
                            { type = NavType.IntType })
                    ) { backStackEntry ->
                        val pokemonName = backStackEntry.arguments?.getString("pokemonName")
                        val color = backStackEntry.arguments?.getInt("dominantColor")
                        color?.let {
                            Color(it)
                        } ?: Color.White
                    }
                }
            }
        }
    }
}

