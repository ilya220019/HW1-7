package vef.ter.hw1_7.core.network

import vef.ter.hw1_7.core.base.BaseDataSource
import vef.ter.hw1_7.core.model.CameraModelDTO
import vef.ter.hw1_7.core.model.DoorModelDTO

class RemoteDataSource(private val apiService: ApiService) : BaseDataSource() {
    suspend fun getCameras(): Result<CameraModelDTO> {
        return getResult { apiService.getCameras() }
    }

    suspend fun getDoors(): Result<DoorModelDTO> {
        return getResult { apiService.getDoors() }
    }
}