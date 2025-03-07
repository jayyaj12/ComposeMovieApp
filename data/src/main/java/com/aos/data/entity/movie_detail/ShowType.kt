package com.aos.data.entity.movie_detail

import kotlinx.serialization.Serializable

@Serializable
data class ShowType(
    val showTypeGroupNm: String,
    val showTypeNm: String
)