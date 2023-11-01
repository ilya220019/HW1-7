package vef.ter.hw1_7.data.storage

import vef.ter.hw1_7.data.storage.model.CameraModelDTO
import vef.ter.hw1_7.data.storage.model.DoorModelDTO

interface RetrofitStorage {

    suspend fun getCameras(): CameraModelDTO

    suspend fun getDoors(): DoorModelDTO
}