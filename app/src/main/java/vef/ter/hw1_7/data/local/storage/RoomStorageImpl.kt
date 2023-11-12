package vef.ter.hw1_7.data.local.storage

import vef.ter.hw1_7.data.local.dao.NoteDao
import vef.ter.hw1_7.data.local.storage.models.NoteDTO

class RoomStorageImpl(private val dao: NoteDao) : RoomStorage {
    override suspend fun getAllNotes(): List<NoteDTO> = dao.getAllNotes()
}