package vef.ter.hw1_7.presentation.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vef.ter.hw1_7.core.base.BaseViewModel
import vef.ter.hw1_7.domain.model.CameraModel
import vef.ter.hw1_7.domain.use_cases.GetAllCamerasUseCase

class CameraViewModel(private val getCameras: GetAllCamerasUseCase) : BaseViewModel() {

    private val _cameras = MutableLiveData<CameraModel>()
    val cameras: LiveData<CameraModel> get() = _cameras

    fun getCameras() {
        doOperation(
            operation = { getCameras.executeRequest() },
            success = { _cameras.postValue(it) }
        )
    }
}