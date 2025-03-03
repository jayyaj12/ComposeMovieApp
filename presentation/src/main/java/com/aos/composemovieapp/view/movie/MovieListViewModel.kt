package com.aos.composemovieapp.view.movie

import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aos.composemovieapp.view.util.Date
import com.aos.domain.use_case.GetBookListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetBookListUseCase
): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getMovieListUseCase(Date.getYesterday())
        }
    }

}