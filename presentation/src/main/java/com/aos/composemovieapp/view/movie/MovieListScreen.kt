package com.aos.composemovieapp.view.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.aos.composemovieapp.view.ui.theme.ComposeMovieAppTheme
import com.aos.domain.model.UiMovieListModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMovieAppTheme {
                MovieListUi()
            }
        }
    }
}

@Composable
fun MovieListUi(viewModel: MovieListViewModel = hiltViewModel()) {
    val movieList by viewModel.movieList.collectAsState() // ✅ `StateFlow` 사용

    LazyColumn {
        items(movieList) { movie ->
            MovieItem(item = movie)
            HorizontalDivider()
        }
    }
}

@Composable
fun MovieItem(item: UiMovieListModel, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(8.dp)
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
        MovieListUi()
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
            )
        )
    }
}