package com.aos.data.entity.movie_list

import com.aos.domain.model.UiMovieListModel
import kotlinx.serialization.Serializable
import java.text.NumberFormat
import java.util.Locale

@Serializable
data class GetMovieListEntity(
    val boxOfficeResult: BoxOfficeResult
)

fun GetMovieListEntity.toMovieListModel(): List<UiMovieListModel> {
    return this.boxOfficeResult.dailyBoxOfficeList.map {
        UiMovieListModel(
            audiAcc = "${NumberFormat.getNumberInstance(Locale.US).format(it.audiAcc.toInt())}명",
            audiChange = "${it.audiChange}%",
            movieCd = it.movieCd,
            movieNm = it.movieNm,
            openDt = it.openDt,
            rank = "${it.rank}위",
            rankInten = if (it.rankInten == "0") {
                "-"
            } else {
                if(it.rankInten.toInt() > 0) {
                    "↑ ${it.rankInten}"
                } else {
                    "↓ ${it.rankInten}"
                }
            },
            rankOldAndNew = it.rankOldAndNew,
            rnum = it.rnum.toInt() - 1
        )
    }
}