package com.aos.data.entity.movie_detail

import kotlinx.serialization.Serializable

@Serializable
data class Staff(
    val peopleNm: String,
    val peopleNmEn: String,
    val staffRoleNm: String
)