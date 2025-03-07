package com.aos.composemovieapp.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aos.composemovieapp.view.movie.detail.MovieDetailScreen
import com.aos.composemovieapp.view.movie.list.MovieListScreen
import com.aos.composemovieapp.view.ui.theme.ComposeMovieAppTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeMovieAppTheme {
                Surface(color = Color.White) {
                    val navController = rememberNavController()
                    Timber.e("NavController Created: $navController")

                    NavHost(
                        navController = navController,
                        startDestination = Screen.MovieListScreen.route
                    ) {
                        Log.d("Navigation", "NavHost Initialized with startDestination: ${Screen.MovieListScreen.route}")
                        composable(
                            route = Screen.MovieListScreen.route
                        ) {
                            Log.d("Navigation", "Navigating to MovieListScreen")
                            MovieListScreen(navController)
                        }
                        composable(
                            route = Screen.MovieDetailScreen.route + "/{movieCd}"
                        ) {
                            MovieDetailScreen()
                        }
                    }
                }
            }
        }
    }
}