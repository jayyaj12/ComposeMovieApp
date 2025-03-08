package com.aos.composemovieapp.view.movie.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.aos.composemovieapp.base.BaseViewModel
import kotlinx.coroutines.delay
import timber.log.Timber

object UiEventHandler {

    @Composable
    fun EventUi(event: BaseViewModel.Event) {
        var isLoading by remember { mutableStateOf(false) }
        var toastText by remember { mutableStateOf("") }

        LaunchedEffect(event) {
            Timber.e("event $event")

            when (event) {
                is BaseViewModel.Event.ShowToast -> {
                    toastText = event.message
                    delay(2000)
                    toastText = ""
                }
                is BaseViewModel.Event.ShowErrorToast -> {
                    isLoading = false
                    toastText = event.message
                    delay(2000)
                    toastText = ""
                }
                is BaseViewModel.Event.ShowToastRes -> toastText = event.message.toString()
                is BaseViewModel.Event.ExpiredToken -> TODO()
                is BaseViewModel.Event.ShowLoading -> isLoading = true
                is BaseViewModel.Event.HideLoading -> isLoading = false
                is BaseViewModel.Event.Nothing -> {}
            }
        }

        LoadingUi(isLoading)
        ToastUi(toastText)
    }

    @Composable
    private fun LoadingUi(isLoading: Boolean) {
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }

    @Composable
    private fun ToastUi(text: String) {
        var isVisible by remember { mutableStateOf(false) }

        LaunchedEffect(text) {
            isVisible = text.isNotBlank()
        }

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(500)),
            exit = fadeOut(tween(500))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    modifier = Modifier
                        .size(360.dp, 60.dp)
                        .background(color = Color.White)
                        .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                        .wrapContentHeight(Alignment.CenterVertically),
                    text = text,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}