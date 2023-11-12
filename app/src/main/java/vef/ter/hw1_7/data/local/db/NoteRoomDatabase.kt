package vef.ter.hw1_7.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import vef.ter.hw1_7.data.local.dao.NoteDao
import vef.ter.hw1_7.data.local.storage.models.NoteDTO

@Database(entities = [NoteDTO::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {

    abstract fun getDao(): NoteDao

}