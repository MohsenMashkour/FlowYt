package com.mkrdeveloper.flowyt

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val repo = MainRepository()

    // MutableStateFlow to keep track of the emitted value
    private val _currentValue = mutableIntStateOf(0)
    val currentValue: State<Int>
    get() = _currentValue

    // Function to start emitting values
    init {
        /*repo.generateNumber().forEach {
            _currentValue.intValue = it
            Log.d("myTag", "startFlow: $it")
        }*/

        viewModelScope.launch {
            repo.simpleFlow().collect {
                _currentValue.intValue = it
                Log.d("myTag", "startFlow: $it")
            }
        }

        Log.d("myTag", "done")
    }

}
