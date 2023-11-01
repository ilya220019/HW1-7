package vef.ter.hw1_7.domain.repository

import vef.ter.hw1_7.data.storage.model.Note

interface NoteRepository {
    suspend fun getAllNotes(): List<Note>
}