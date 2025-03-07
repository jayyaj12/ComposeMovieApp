package com.aos.data.entity.movie_detail

import kotlinx.serialization.Serializable

@Serializable
data class Company(
    val companyCd: String,
    val companyNm: String,
    val companyNmEn: String,
    val companyPartNm: String
)