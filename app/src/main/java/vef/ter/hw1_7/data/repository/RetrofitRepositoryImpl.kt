package vef.ter.hw1_7.data.repository

import vef.ter.hw1_7.data.storage.RetrofitStorage
import vef.ter.hw1_7.data.storage.model.CameraModelDTO
import vef.ter.hw1_7.data.storage.model.DoorModelDTO
import vef.ter.hw1_7.domain.model.CameraModel
import vef.ter.hw1_7.domain.model.DoorModel
import vef.ter.hw1_7.domain.repository.Repository

class RetrofitRepositoryImpl(private val retrofitStorage: RetrofitStorage) : Repository {

    override suspend fun getCameras(): Result<CameraModel> {
        return mapToCameraModel(retrofitStorage.getCameras())
    }

    override suspend fun getDoors(): Result<DoorModel> {
        return mapToDoorModel(retrofitStorage.getDoors())
    }

    private fun mapToDoorModel(doorsModel: DoorModelDTO): Result<DoorModel> {
        val doorsModelData = mutableListOf<DoorModel.Data>()
        doorsModel.data.mapTo(doorsModelData) {
            DoorModel.Data(it.favorites, it.id, it.name, it.room ?: "", it.snapshot)
        }
        return Result.success(DoorModel(doorsModelData, doorsModel.success))
    }

    private fun mapToCameraModel(cameraModel: CameraModelDTO): Result<CameraModel> {
        val camerasModelDataCameras = mutableListOf<CameraModel.Data.Camera>()
        cameraModel.data.cameras.mapTo(camerasModelDataCameras) {
            CameraModel.Data.Camera(
                it.favorites,
                it.id,
                it.name,
                it.rec,
                it.room ?: "",
                it.snapshot
            )
        }
        val camerasModelData =
            CameraModel.Data(camerasModelDataCameras.toList(), cameraModel.data.room)
        return Result.success(CameraModel(camerasModelData, cameraModel.success))
    }


}