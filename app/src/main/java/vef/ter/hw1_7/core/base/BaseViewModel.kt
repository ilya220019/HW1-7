package vef.ter.hw1_7.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import vef.ter.hw1_7.domain.utils.Resource
import vef.ter.hw1_7.presentation.utils.State

open class BaseViewModel<T> : ViewModel() {
    private var _viewState = MutableStateFlow<State<T>>(State.Empty())
    val viewState: StateFlow<State<T>> = _viewState.asStateFlow()

    protected suspend fun doOperation(
        operation: suspend () -> Flow<Resource<T>>
    ) {
        val dataResult = operation()
        dataResult.onEach {
            when (it) {
                is Resource.Loading -> _viewState.value = State.Loading()
                is Resource.Success ->
                    if (it.data == null) {
                        _viewState.value = State.Empty()
                    } else {
                        _viewState.value = State.Success(it.data)
                    }

                is Resource.Error -> _viewState.value = State.Error(it.message ?: "Some error")
            }
        }.launchIn(viewModelScope)
    }
}