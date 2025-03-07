package com.aos.data.repository.remote.movie

import com.aos.data.entity.movie_detail.GetMovieDetailEntity
import com.aos.data.entity.movie_list.GetMovieListEntity
import com.aos.data.network.state.NetworkState

interface MovieRemoteDataSource {

    suspend fun getMovieList(targetDate: String) : NetworkState<GetMovieListEntity>
    suspend fun getMovie(movieCd: String) : NetworkState<GetMovieDetailEntity>
}