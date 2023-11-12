package vef.ter.hw1_7.data.utils

import vef.ter.hw1_7.data.local.storage.models.NoteDTO
import vef.ter.hw1_7.data.remote.storage.model.CameraModelDTO
import vef.ter.hw1_7.data.remote.storage.model.DoorModelDTO
import vef.ter.hw1_7.domain.model.CameraModel
import vef.ter.hw1_7.domain.model.DoorModel
import vef.ter.hw1_7.domain.model.Note

fun CameraModelDTO.mapToCameraModel(): CameraModel {
    val camerasModelDataCameras = mutableListOf<CameraModel.Data.Camera>()
    this.data.cameras.mapTo(camerasModelDataCameras){
        CameraModel.Data.Camera(it.favorites,it.id, it.name, it.rec, it.room?:"", it.snapshot)
    }
    val camerasModelData = CameraModel.Data(camerasModelDataCameras.toList(),this.data.room)
    return CameraModel(camerasModelData,this.success)
}

fun DoorModelDTO.mapToDoorsModel(): DoorModel {
    val doorsModelData = mutableListOf<DoorModel.Data>()
    this.data.mapTo(doorsModelData) {
        DoorModel.Data(it.favorites, it.id, it.name, it.room?:"", it.snapshot)
    }
    return DoorModel(doorsModelData, this.success)
}

fun List<NoteDTO>.mapToNote():List<Note> = this.map{
    Note(
        id = it.id,
        title = it.title,
        description = it.description,
        isDone = it.isDone
    )
}

fun Note.mapToNoteDTO(): NoteDTO = NoteDTO(
    id = this.id,
    title = this.title,
    description = this.description,
    isDone = this.isDone
)