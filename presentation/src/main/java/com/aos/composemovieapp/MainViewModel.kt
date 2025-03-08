package com.aos.composemovieapp

import com.aos.composemovieapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): BaseViewModel() {

    fun showError() {
        baseEvent(Event.ShowToast("error"))
    }

}