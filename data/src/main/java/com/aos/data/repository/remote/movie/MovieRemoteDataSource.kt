package com.aos.data.repository.remote.movie

import com.aos.data.entity.movie_list.GetMovieListEntity
import com.aos.util.NetworkState

interface MovieRemoteDataSource {

    suspend fun getMovieList(targetDate: String) : NetworkState<GetMovieListEntity>
}