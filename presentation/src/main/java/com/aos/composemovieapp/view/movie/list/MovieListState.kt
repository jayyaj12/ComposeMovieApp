package com.aos.composemovieapp.view.movie.list

import com.aos.domain.model.movie.UiMovieListModel

data class MovieListState(
    val movies: List<UiMovieListModel> = emptyList(),
    val error: String = ""
)
