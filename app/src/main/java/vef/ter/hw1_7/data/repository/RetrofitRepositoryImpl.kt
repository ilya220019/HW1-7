package vef.ter.hw1_7.data.repository



import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import vef.ter.hw1_7.data.local.storage.RoomStorage
import vef.ter.hw1_7.data.remote.storage.RetrofitStorage
import vef.ter.hw1_7.data.utils.mapToCameraModel
import vef.ter.hw1_7.data.utils.mapToDoorsModel
import vef.ter.hw1_7.data.utils.mapToNote
import vef.ter.hw1_7.domain.model.CameraModel
import vef.ter.hw1_7.domain.model.DoorModel
import vef.ter.hw1_7.domain.model.Note
import vef.ter.hw1_7.domain.repository.Repository
import vef.ter.hw1_7.domain.utils.Resource

class RetrofitRepositoryImpl(
    private val retrofitStorage: RetrofitStorage,
    private val roomStorage: RoomStorage
) : Repository {

    override suspend fun getCameras(): Flow<Resource<CameraModel>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = retrofitStorage.getCameras().mapToCameraModel()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }

    override suspend fun getDoors(): Flow<Resource<DoorModel>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = retrofitStorage.getDoors().mapToDoorsModel()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }
    override suspend fun getAllNotes(): Flow<Resource<List<Note>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = roomStorage.getAllNotes().mapToNote()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }

}