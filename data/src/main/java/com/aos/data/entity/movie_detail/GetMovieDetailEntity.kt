package com.aos.data.entity.movie_detail

import com.aos.domain.model.movie.Actor
import com.aos.domain.model.movie.UiMovieModel
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Serializable
data class GetMovieDetailEntity(
    val movieInfoResult: MovieInfoResult
)

fun GetMovieDetailEntity.toUiMovieModel(): UiMovieModel {
    val movieInfo = this.movieInfoResult.movieInfo
    return UiMovieModel(
        actors = movieInfo.actors.map {
            Actor(
                cast = it.cast,
                peopleNm = it.peopleNm
            )
        },
        directors = movieInfo.directors.map {
            it.peopleNm
        },
        genres = movieInfo.genres.map {
            it.genreNm
        },
        movieNm = movieInfo.movieNm,
        nations = movieInfo.nations.map {
            it.nationNm
        },
        openDt = run {
            val inputFormat = SimpleDateFormat("yyyyMMdd", Locale.KOREA) // ✅ 입력 데이터 포맷
            val outputFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREA) // ✅ 출력 포맷

            val date: Date? = try {
                inputFormat.parse(movieInfo.openDt) // ✅ String → Date 변환
            } catch (e: Exception) {
                null // ✅ 변환 실패 시 null 반환
            }

            date?.let { outputFormat.format(it) } ?: "날짜 변환 오류"
        },
        showTm = "${movieInfo.showTm}분")
}