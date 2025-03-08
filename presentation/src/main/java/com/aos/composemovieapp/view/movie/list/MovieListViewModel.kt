package com.aos.composemovieapp.view.movie.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.aos.composemovieapp.base.BaseViewModel
import com.aos.core.util.Date
import com.aos.domain.use_case.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase,
) : BaseViewModel() {

    private val _movieList = mutableStateOf(MovieListState())
    val movieList: State<MovieListState> = _movieList

    init {
        baseEvent(Event.ShowLoading)
        viewModelScope.launch(Dispatchers.IO) {
            getMovieListUseCase(Date.getYesterday()).onSuccess {
                baseEvent(Event.HideLoading)
                _movieList.value = MovieListState(movies = it)
            }.onFailure {
                _movieList.value = MovieListState(error = it.message ?: "UnKnownError")
                baseEvent(Event.ShowErrorToast("데이터를 불러오는데 실패하였습니다."))
            }
        }
    }
}