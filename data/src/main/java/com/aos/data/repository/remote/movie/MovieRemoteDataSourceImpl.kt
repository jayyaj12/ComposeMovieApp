package com.aos.data.repository.remote.movie

import com.aos.data.entity.movie_detail.GetMovieDetailEntity
import com.aos.data.network.api.MovieService
import com.aos.data.entity.movie_list.GetMovieListEntity
import com.aos.data.network.state.NetworkState
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val apiService: MovieService): MovieRemoteDataSource {
    override suspend fun getMovieList(targetDate: String): NetworkState<GetMovieListEntity> {
        return apiService.getMovieList(targetDate)
    }

    override suspend fun getMovie(movieCd: String): NetworkState<GetMovieDetailEntity> {
        return apiService.getMovie(movieCd)
    }
}