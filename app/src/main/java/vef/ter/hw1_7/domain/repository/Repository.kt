package vef.ter.hw1_7.domain.repository

import kotlinx.coroutines.flow.Flow
import vef.ter.hw1_7.domain.model.CameraModel
import vef.ter.hw1_7.domain.model.DoorModel
import vef.ter.hw1_7.domain.model.Note
import vef.ter.hw1_7.domain.utils.Resource

interface Repository {

    suspend fun getCameras(): Flow<Resource<CameraModel>>
    suspend fun getDoors(): Flow<Resource<DoorModel>>
    suspend fun getAllNotes(): Flow<Resource<List<Note>>>

}