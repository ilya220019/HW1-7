package vef.ter.hw1_7.ui.door

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vef.ter.hw1_7.core.base.BaseViewModel
import vef.ter.hw1_7.core.model.DoorModelDTO
import vef.ter.hw1_7.domain.repository.Repository

class DoorViewModel(private val repository: Repository) : BaseViewModel() {

    private val _doors = MutableLiveData<DoorModelDTO>()
    val doors: LiveData<DoorModelDTO> get() = _doors

    fun getDoors() = doOperation(
        operation = { repository.getDoors() },
        success = { _doors.postValue(it) }
    )

}