package com.aos.data.entity.movie_list

import com.aos.domain.model.UiMovieListModel
import kotlinx.serialization.Serializable

@Serializable
data class GetMovieListEntity(
    val boxOfficeResult: BoxOfficeResult
)

fun GetMovieListEntity.toMovieListModel(): List<UiMovieListModel> {
    return this.boxOfficeResult.dailyBoxOfficeList.map {
        UiMovieListModel(
            audiAcc = it.audiAcc,
            audiChange = "${it.audiChange}%",
            movieCd = it.movieCd,
            movieNm = it.movieNm,
            openDt = it.openDt,
            rank = "${it.rank}위",
            rankInten = it.rankInten,
            rankOldAndNew = it.rankOldAndNew,
            rnum = it.rnum.toInt() - 1
        )
    }
}