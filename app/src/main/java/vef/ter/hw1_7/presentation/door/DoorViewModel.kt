package vef.ter.hw1_7.presentation.door

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import vef.ter.hw1_7.core.base.BaseViewModel
import vef.ter.hw1_7.domain.model.DoorModel
import vef.ter.hw1_7.domain.use_cases.GetAllDoorsUseCase
import vef.ter.hw1_7.presentation.utils.State
import javax.inject.Inject

@HiltViewModel
class DoorViewModel @Inject constructor(private val getAllDoorsUseCase: GetAllDoorsUseCase) :
    BaseViewModel<DoorModel>() {
    private val _doors = MutableStateFlow<State<List<DoorModel>>>(State.Empty())
    val doors: StateFlow<State<List<DoorModel>>> = _doors

    suspend fun getDoors() = doOperation(
        operation = { getAllDoorsUseCase.executeRequest() }
    )
}