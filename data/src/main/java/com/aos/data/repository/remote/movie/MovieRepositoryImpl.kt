package com.aos.data.repository.remote.movie

import com.aos.data.entity.movie_list.toMovieListModel
import com.aos.data.util.RetrofitFailureStateException
import com.aos.domain.model.UiMovieListModel
import com.aos.domain.repository.MovieRepository
import com.aos.util.NetworkState
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRepository {

    override suspend fun getMovieList(targetDate: String): Result<List<UiMovieListModel>> {
        return when (val data = movieRemoteDataSourceImpl.getMovieList(targetDate)) {
            is NetworkState.Success -> Result.success(data.body.toMovieListModel())
            is NetworkState.Failure -> Result.failure(
                RetrofitFailureStateException(data.error, data.code)
            )

            is NetworkState.NetworkError -> Result.failure(IllegalStateException("NetworkError"))
            is NetworkState.UnknownError -> {
                Result.failure(IllegalStateException("unKnownError"))
            }
        }
    }

}