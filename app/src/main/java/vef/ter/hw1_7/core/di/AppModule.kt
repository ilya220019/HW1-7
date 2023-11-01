package vef.ter.hw1_7.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vef.ter.hw1_7.BuildConfig.BASE_URL
import vef.ter.hw1_7.core.network.ApiService
import vef.ter.hw1_7.data.local.dao.NoteDao
import vef.ter.hw1_7.data.local.db.NoteRoomDatabase
import vef.ter.hw1_7.data.repository.NoteRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context,
        klass = NoteRoomDatabase::class.java,
        name = "notes"
    ).build()

    @Provides
    fun provideNoteRepository(noteDao: NoteDao) = NoteRepositoryImpl(noteDao)

    @Provides
    fun provideNoteDao(database: NoteRoomDatabase) = database.getDao()

    @Provides
    fun provideApi(): ApiService =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
}