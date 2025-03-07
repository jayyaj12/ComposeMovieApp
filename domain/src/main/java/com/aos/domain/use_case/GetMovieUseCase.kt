package com.aos.domain.use_case

import com.aos.domain.model.movie.UiMovieModel
import com.aos.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

   suspend operator fun invoke(
       movieCd: String
   ): Result<UiMovieModel> {
       return movieRepository.getMovie(movieCd)
   }

}