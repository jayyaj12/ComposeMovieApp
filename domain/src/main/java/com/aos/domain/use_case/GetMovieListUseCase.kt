package com.aos.domain.use_case

import com.aos.domain.model.movie.UiMovieListModel
import com.aos.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(
        targetDate: String
    ): Result<List<UiMovieListModel>> {
        return movieRepository.getMovieList(targetDate)
    }

}