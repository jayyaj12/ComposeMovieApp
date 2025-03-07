package com.aos.domain.repository

import com.aos.domain.model.movie.UiMovieListModel
import com.aos.domain.model.movie.UiMovieModel

interface MovieRepository {

    suspend fun getMovieList(targetDate: String) : Result<List<UiMovieListModel>>
    suspend fun getMovie(movieCd: String) : Result<UiMovieModel>

}