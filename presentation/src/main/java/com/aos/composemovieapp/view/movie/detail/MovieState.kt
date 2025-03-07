package com.aos.composemovieapp.view.movie.detail

import com.aos.domain.model.movie.UiMovieModel

data class MovieState(
    val movie: UiMovieModel = UiMovieModel(),
    val error: String = ""
)
