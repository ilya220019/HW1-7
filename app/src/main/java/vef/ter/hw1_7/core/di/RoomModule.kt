package vef.ter.hw1_7.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import vef.ter.hw1_7.data.local.dao.NoteDao
import vef.ter.hw1_7.data.local.db.NoteRoomDatabase
import vef.ter.hw1_7.data.local.storage.RoomStorage
import vef.ter.hw1_7.data.local.storage.RoomStorageImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context,
        klass = NoteRoomDatabase::class.java,
        name = "notes"
    ).build()

    @Provides
    fun provideNoteDao(database: NoteRoomDatabase) = database.getDao()

    @Provides
    fun provideRoomStorage(noteDao: NoteDao): RoomStorage = RoomStorageImpl(noteDao)
}