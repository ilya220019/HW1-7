package vef.ter.hw1_7.presentation.camera

import dagger.hilt.android.lifecycle.HiltViewModel
import vef.ter.hw1_7.core.base.BaseViewModel
import vef.ter.hw1_7.domain.model.CameraModel
import vef.ter.hw1_7.domain.use_cases.GetAllCamerasUseCase
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(private val getCameras: GetAllCamerasUseCase) :
    BaseViewModel<CameraModel>() {

    suspend fun getCameras() = doOperation(
        operation = { getCameras.executeRequest() }
    )
}