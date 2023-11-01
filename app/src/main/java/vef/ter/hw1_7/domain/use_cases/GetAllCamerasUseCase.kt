package vef.ter.hw1_7.domain.use_cases

import vef.ter.hw1_7.domain.model.CameraModel
import vef.ter.hw1_7.domain.repository.Repository

class GetAllCamerasUseCase(private val repository: Repository) {

    suspend fun executeRequest(): Result<CameraModel> = repository.getCameras()
}