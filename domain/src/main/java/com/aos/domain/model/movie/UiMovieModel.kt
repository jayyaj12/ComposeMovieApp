package com.aos.domain.model.movie

data class UiMovieModel(
    val actors: List<Actor> = emptyList(),
    val directors: List<String> = emptyList(),
    val genres: List<String> = emptyList(),
    val movieNm: String = "",
    val nations: List<String> = emptyList(),
    val openDt: String = "",
    val showTm: String = "",
)

data class Actor(
    val cast: String,
    val peopleNm: String,
)