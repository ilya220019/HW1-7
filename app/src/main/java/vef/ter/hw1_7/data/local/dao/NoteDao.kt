package vef.ter.hw1_7.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import vef.ter.hw1_7.data.local.storage.models.NoteDTO


@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<NoteDTO>
}