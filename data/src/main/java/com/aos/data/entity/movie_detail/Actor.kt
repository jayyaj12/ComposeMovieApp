package com.aos.data.entity.movie_detail

import kotlinx.serialization.Serializable

@Serializable
data class Actor(
    val cast: String,
    val castEn: String,
    val peopleNm: String,
    val peopleNmEn: String
)