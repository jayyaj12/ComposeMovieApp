package com.aos.data.entity.movie_detail

import kotlinx.serialization.Serializable

@Serializable
data class Director(
    val peopleNm: String,
    val peopleNmEn: String
)