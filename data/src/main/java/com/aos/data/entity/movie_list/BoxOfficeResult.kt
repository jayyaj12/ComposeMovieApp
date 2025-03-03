package com.aos.data.entity.movie_list

import kotlinx.serialization.Serializable

@Serializable
data class BoxOfficeResult(
    val boxofficeType: String,
    val dailyBoxOfficeList: List<DailyBoxOffice>,
    val showRange: String
)