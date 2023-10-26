package vef.ter.hw1_7.ui.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vef.ter.hw1_7.core.base.BaseViewModel
import vef.ter.hw1_7.core.model.CameraModelDTO
import vef.ter.hw1_7.domain.repository.Repository

class CameraViewModel(private val repository: Repository) : BaseViewModel() {

    private val _cameras = MutableLiveData<CameraModelDTO>()
    val cameras: LiveData<CameraModelDTO> get() = _cameras

    fun getCameras() = doOperation(
        operation = { repository.getCameras() },
        success = { _cameras.postValue(it) }
    )
}