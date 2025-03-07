package com.aos.domain.use_case

import androidx.paging.PagingData
import com.aos.domain.model.UiMovieListModel
import com.aos.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(
        targetDate: String
    ): Result<List<UiMovieListModel>> {
        return movieRepository.getMovieList(targetDate)
    }

}