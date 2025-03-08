package com.aos.composemovieapp.base

import android.util.Log
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aos.composemovieapp.util.MutableEventFlow
import com.aos.composemovieapp.util.asEventFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {
    private val _baseStateFlow = MutableEventFlow<Event>()
    val baseStateFlow = _baseStateFlow.asEventFlow()
    fun baseEvent(event: Event) {
        Log.e("BaseViewModel$_baseStateFlow", "event emit 요청: $event") // ✅ emit 요청 로그 추가
        viewModelScope.launch {
            Log.e("BaseViewModel$_baseStateFlow", "event emit 완료: $event") // ✅ emit 완료 로그 추가
            _baseStateFlow.emit(event)
        }
    }
    sealed class Event {
        data class ShowToast(val message: String) : Event()
        data class ShowErrorToast(val message: String) : Event()
        data class ShowToastRes(@StringRes val message: Int) : Event()
//        data class ShowSuccessToast(val message: String) : Event()
//        data class ShowSuccessToastRes(@StringRes val message: Int) : Event()
        
        object Nothing: Event()
        object ShowLoading: Event()
        object HideLoading: Event()
        object ExpiredToken: Event()
    }
}