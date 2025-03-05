package com.aos.composemovieapp.view.movie

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aos.composemovieapp.base.BaseViewModel
import com.aos.composemovieapp.util.EventFlow
import com.aos.composemovieapp.util.MutableEventFlow
import com.aos.core.util.Date
import com.aos.domain.model.UiMovieListModel
import com.aos.domain.use_case.GetBookListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetBookListUseCase
): BaseViewModel() {

    private val _movieList = MutableStateFlow<List<UiMovieListModel>>(emptyList())
    val movieList: StateFlow<List<UiMovieListModel>> get() = _movieList

    init {
        viewModelScope.launch(Dispatchers.IO) {

            getMovieListUseCase(Date.getYesterday()).onSuccess {
                baseEvent(Event.HideLoading)
                _movieList.emit(it)
            }.onFailure {
                baseEvent(Event.HideLoading)
            }
        }
    }
}