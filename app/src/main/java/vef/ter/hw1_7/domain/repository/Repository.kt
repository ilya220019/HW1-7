package vef.ter.hw1_7.domain.repository

import vef.ter.hw1_7.core.model.CameraModelDTO
import vef.ter.hw1_7.core.model.DoorModelDTO
import vef.ter.hw1_7.core.network.RemoteDataSource

class Repository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getCameras(): Result<CameraModelDTO> {
        return remoteDataSource.getCameras()
    }

    suspend fun getDoors(): Result<DoorModelDTO> {
        return remoteDataSource.getDoors()
    }

}