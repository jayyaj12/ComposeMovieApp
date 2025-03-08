package com.aos.composemovieapp.view.movie.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aos.composemovieapp.MainViewModel
import com.aos.composemovieapp.base.BaseViewModel
import com.aos.composemovieapp.view.Screen
import com.aos.composemovieapp.view.movie.common.UiEventHandler
import com.aos.composemovieapp.view.ui.theme.ComposeMovieAppTheme
import com.aos.domain.model.movie.UiMovieListModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@Composable
fun MovieListScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    Box(modifier = Modifier.fillMaxSize())
    {
        MovieListUi(navController = navController)
    }
}

@Composable
fun MovieListUi(navController: NavController, viewModel: MovieListViewModel = hiltViewModel()) {
    val movieState = viewModel.movieList.value
    val event by viewModel.baseStateFlow.collectAsState(BaseViewModel.Event.Nothing)

    Box {
        LazyColumn {
            items(movieState.movies) { movie ->
                MovieItem(item = movie, onItemClick = {
                    navController.navigate(Screen.MovieDetailScreen.route + "/${movie.movieCd}")
                })
                HorizontalDivider()
            }
        }

        UiEventHandler.EventUi(event = event)
    }
}

@Composable
fun MovieItem(
    item: UiMovieListModel,
    modifier: Modifier = Modifier,
    onItemClick: (UiMovieListModel) -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(8.dp),
        onClick = {
            onItemClick(item)
        },
        color = Color.White
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = item.rankOldAndNew,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.alignByBaseline()
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = item.rank, textAlign = TextAlign.Center,
                        modifier = Modifier.alignByBaseline()
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = item.rankInten, textAlign = TextAlign.Center,
                        modifier = Modifier.alignByBaseline()
                    )
                }
                Text(text = item.movieNm, modifier = Modifier.align(Alignment.CenterStart))
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 80.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = item.audiAcc, modifier = Modifier.alignByBaseline() // ✅ Baseline 정렬
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = item.audiChange, modifier = Modifier.alignByBaseline()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeMovieAppTheme {
        MovieListUi(rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    ComposeMovieAppTheme {
        MovieItem(
            UiMovieListModel(
                audiAcc = "aliquip",
                audiChange = "patrioque",
                movieCd = "eloquentiam",
                movieNm = "ante",
                openDt = "graecis",
                rank = "1위",
                rankInten = "-",
                rankOldAndNew = "labores",
                rnum = 2158
            ),
            onItemClick = {}
        )
    }
}