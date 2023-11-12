package vef.ter.hw1_7.data.local.storage

import vef.ter.hw1_7.data.local.storage.models.NoteDTO

interface RoomStorage {
    suspend fun getAllNotes(): List<NoteDTO>

}