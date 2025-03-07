package com.aos.composemovieapp.view.movie.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.aos.composemovieapp.base.BaseViewModel
import com.aos.domain.use_case.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    savedStateHandle: SavedStateHandle
): BaseViewModel() {

    private var _movie = mutableStateOf<MovieState>(MovieState())
    val movie: State<MovieState> = _movie

    init {
        savedStateHandle.get<String>("movieCd")?.let {movieCd ->
            getMovie(movieCd)
        }
    }

    // 상세 영화
    private fun getMovie(movieCd: String) {
        viewModelScope.launch(Dispatchers.IO) {
            baseEvent(Event.ShowLoading)
            getMovieUseCase(movieCd).onSuccess {
                baseEvent(Event.HideLoading)
                _movie.value = MovieState(movie = it)
            }.onFailure {
                baseEvent(Event.HideLoading)
                _movie.value = MovieState(error = it.message ?: "Unknown 에러 발생")
                baseEvent(Event.ShowToast(it.message ?: "Unknown 에러 발생"))
            }
        }
    }

}