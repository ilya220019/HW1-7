package vef.ter.hw1_7.core.network

import retrofit2.Response
import retrofit2.http.GET
import vef.ter.hw1_7.core.model.CameraModelDTO
import vef.ter.hw1_7.core.model.DoorModelDTO

interface ApiService {
    @GET("cameras")
    suspend fun getCameras(): Response<CameraModelDTO>

    @GET("doors")
    suspend fun getDoors(): Response<DoorModelDTO>
}