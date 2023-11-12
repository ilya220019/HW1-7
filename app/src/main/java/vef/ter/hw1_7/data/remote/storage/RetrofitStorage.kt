package vef.ter.hw1_7.data.remote.storage

import vef.ter.hw1_7.data.remote.storage.model.CameraModelDTO
import vef.ter.hw1_7.data.remote.storage.model.DoorModelDTO

interface RetrofitStorage {

    suspend fun getCameras(): CameraModelDTO

    suspend fun getDoors(): DoorModelDTO
}