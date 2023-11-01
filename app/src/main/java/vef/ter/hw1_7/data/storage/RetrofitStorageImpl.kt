package vef.ter.hw1_7.data.storage

import vef.ter.hw1_7.core.network.ApiService
import vef.ter.hw1_7.data.storage.model.CameraModelDTO
import vef.ter.hw1_7.data.storage.model.DoorModelDTO

class RetrofitStorageImpl(private val apiService: ApiService):RetrofitStorage {
    override suspend fun getCameras(): CameraModelDTO {
        val apiBody = apiService.getCameras().body()
        return CameraModelDTO(apiBody!!.data,apiBody.success)
    }

    override suspend fun getDoors(): DoorModelDTO {
        val apiBody = apiService.getDoors().body()
        return DoorModelDTO(apiBody!!.data, apiBody.success)
    }
}