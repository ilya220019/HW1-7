package vef.ter.hw1_7.domain.repository

import vef.ter.hw1_7.domain.model.CameraModel
import vef.ter.hw1_7.domain.model.DoorModel

interface Repository {

    suspend fun getCameras(): Result<CameraModel>

    suspend fun getDoors(): Result<DoorModel>

}