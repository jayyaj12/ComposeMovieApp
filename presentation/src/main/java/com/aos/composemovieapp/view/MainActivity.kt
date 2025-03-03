package com.aos.composemovieapp.view

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.aos.composemovieapp.view.movie.MovieListViewModel
import com.aos.composemovieapp.view.ui.theme.ComposeMovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMovieAppTheme {
                MovieListScreen()
            }
        }
    }
}

@Composable
fun MovieListScreen(viewModel: MovieListViewModel = hiltViewModel()) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeMovieAppTheme {
        MovieListScreen()
    }
}