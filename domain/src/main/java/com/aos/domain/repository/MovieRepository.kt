package com.aos.domain.repository

import com.aos.domain.model.UiMovieListModel

interface MovieRepository {

    suspend fun getMovieList(targetDate: String) : Result<List<UiMovieListModel>>

}