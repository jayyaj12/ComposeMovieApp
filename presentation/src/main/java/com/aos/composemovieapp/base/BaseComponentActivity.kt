package com.aos.composemovieapp.base

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelLazy
import java.lang.reflect.ParameterizedType

abstract class BaseComponentActivity<VM: BaseViewModel>: ComponentActivity() {

    private val viewModelClass = ((javaClass.genericSuperclass as ParameterizedType?)
        ?.actualTypeArguments
        ?.get(0) as Class<VM>).kotlin // ✅ `.get(1)` → `.get(0)`으로 수정

    protected open val viewModel by ViewModelLazy( // ✅ protected로 변경
        viewModelClass,
        { viewModelStore },
        { defaultViewModelProviderFactory },
        { defaultViewModelCreationExtras },
    )

//    @Composable
//    protected open fun EventUi() {
//        val event by viewModel.baseStateFlow.collectAsState()
//        var isLoading by remember { mutableStateOf(false) }
//
//        when(event) {
//            is BaseViewModel.Event.ShowLoading -> isLoading = true
//            is BaseViewModel.Event.HideLoading -> isLoading = false
//            is BaseViewModel.Event.ExpiredToken -> { TODO() }
//            is BaseViewModel.Event.ShowToast -> Toast.makeText(LocalContext.current, (event as BaseViewModel.Event.ShowToast).message, Toast.LENGTH_SHORT).show()
//            is BaseViewModel.Event.ShowToastRes -> Toast.makeText(LocalContext.current, (event as BaseViewModel.Event.ShowToastRes).message, Toast.LENGTH_SHORT).show()
//            is BaseViewModel.Event.Nothing -> {  }
//        }
//
//        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
//            LoadingUi(isLoading)
//        }
//    }
//
//    @Composable
//    fun LoadingUi(isLoading: Boolean) {
//        if(isLoading) {
//            CircularProgressIndicator()
//        }
//    }
}
