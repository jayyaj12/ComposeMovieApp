package com.aos.data.entity.movie_detail

import kotlinx.serialization.Serializable

@Serializable
data class Audit(
    val auditNo: String,
    val watchGradeNm: String
)