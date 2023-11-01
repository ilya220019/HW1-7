package vef.ter.hw1_7.presentation.door

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vef.ter.hw1_7.core.base.BaseViewModel
import vef.ter.hw1_7.domain.model.DoorModel
import vef.ter.hw1_7.domain.use_cases.GetAllDoorsUseCase

class DoorViewModel(private val getAllDoorsUseCase: GetAllDoorsUseCase) : BaseViewModel() {
    private val _doors = MutableLiveData<DoorModel>()
    val doors: LiveData<DoorModel> get() = _doors

    fun getDoors() {
        doOperation(
            operation = { getAllDoorsUseCase.executeRequest() },
            success = { _doors.postValue(it) }
        )
    }
}