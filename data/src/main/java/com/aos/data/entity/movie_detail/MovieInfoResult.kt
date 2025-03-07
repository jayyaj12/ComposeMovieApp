package com.aos.data.entity.movie_detail

import kotlinx.serialization.Serializable

@Serializable
data class MovieInfoResult(
    val movieInfo: MovieInfo,
    val source: String
)