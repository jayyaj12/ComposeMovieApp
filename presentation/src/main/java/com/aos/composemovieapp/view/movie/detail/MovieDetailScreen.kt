package com.aos.composemovieapp.view.movie.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aos.composemovieapp.view.ui.theme.ComposeMovieAppTheme
import com.aos.domain.model.movie.Actor
import com.aos.domain.model.movie.UiMovieModel

@Composable
fun MovieDetailScreen() {
    Surface(color = Color.White) {
        TopLevel()
    }
}

@Composable
fun TopLevel(modifier: Modifier = Modifier, viewModel: MovieDetailViewModel = hiltViewModel()) {
    val movieState by viewModel.movie

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column {
            MovieUi(movieState.movie)
            Spacer(Modifier.size(8.dp))
            GenreUi(movieState.movie.genres)
            Spacer(Modifier.size(8.dp))
            ActorUi(movieState.movie.actors)
            Spacer(Modifier.size(8.dp))
            DirectorUi(movieState.movie.directors)
            Spacer(Modifier.size(8.dp))
            NationUi(movieState.movie.nations)
        }
    }
}

@Composable
fun MovieUi(movie: UiMovieModel) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = movie.movieNm)
        Text(text = movie.openDt)
        Text(text = movie.showTm)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ActorUi(actors: List<Actor>) {
    if (actors.isNotEmpty()) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
        ){
            actors.forEach {actor ->
                ActorItemUi(actor)
            }
        }
    } else {
        Text(text = "불러올 정보가 없습니다.")
    }
}

@Composable
fun ActorItemUi(actor: Actor) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(end = 4.dp, bottom = 4.dp)
            .border(
                1.dp, Color.Black, RoundedCornerShape(10.dp)
            )
    ) {
        Text(modifier = Modifier.padding(8.dp), text = actor.peopleNm)
    }
}

@Composable
fun NationUi(nations: List<String>) {
    if (nations.isNotEmpty()) {
        LazyRow {
            items(nations) { nation ->
                Text(text = nation)
            }
        }
    } else {
        Text(text = "불러올 정보가 없습니다.")
    }
}

@Composable
fun DirectorUi(directors: List<String>) {
    if (directors.isNotEmpty()) {
        LazyRow {
            items(directors) { director ->
                Text(text = director)
            }
        }
    } else {
        Text(text = "불러올 정보가 없습니다.")
    }
}

@Composable
fun GenreUi(genres: List<String>) {
    if (genres.isNotEmpty()) {
        LazyRow {
            items(genres) { genre ->
                Text(text = genre)
            }
        }
    } else {
        Text(text = "불러올 정보가 없습니다.")
    }
}

@Preview(showBackground = true)
@Composable
fun TopLevelPreview() {
    ComposeMovieAppTheme {
        TopLevel()
    }
}

@Preview(showBackground = true)
@Composable
fun MovieUiPreview() {
    ComposeMovieAppTheme {
        MovieUi(
            movie = UiMovieModel(
                actors = listOf(),
                directors = listOf(),
                genres = listOf(),
                movieNm = "Carlye",
                nations = listOf(),
                openDt = "Lydell",
                showTm = "Antony"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActorUiPreview() {
    ComposeMovieAppTheme {
        ActorUi(
            actors = listOf(
                Actor(
                    cast = "Tammi", peopleNm = "Lafayette"
                ),
                Actor(
                    cast = "Tammi", peopleNm = "Lafayette"
                ),
                Actor(
                    cast = "Tammi", peopleNm = "Lafayette"
                ),
                Actor(
                    cast = "Tammi", peopleNm = "Lafayette"
                ),
                Actor(
                    cast = "Tammi", peopleNm = "Lafayette"
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DirectorUiPreview() {
    ComposeMovieAppTheme {
        DirectorUi(
            directors = listOf("Steve", "Foll", "Dev")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NationUiPreview() {
    ComposeMovieAppTheme {
        NationUi(
            nations = listOf("한국")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GenreUiPreview() {
    ComposeMovieAppTheme {
        GenreUi(
            genres = listOf("사극", "드라마")
        )
    }
}