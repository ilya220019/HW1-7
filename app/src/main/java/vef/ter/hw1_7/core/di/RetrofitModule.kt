package vef.ter.hw1_7.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vef.ter.hw1_7.data.remote.network.ApiService
import vef.ter.hw1_7.data.remote.network.RetrofitClient
import vef.ter.hw1_7.data.local.storage.RoomStorage
import vef.ter.hw1_7.data.remote.storage.RetrofitStorage
import vef.ter.hw1_7.data.remote.storage.RetrofitStorageImpl
import vef.ter.hw1_7.data.repository.RetrofitRepositoryImpl
import vef.ter.hw1_7.domain.repository.Repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofitClient() = RetrofitClient()

    @Provides
    @Singleton
    fun provideApiService(retrofitClient: RetrofitClient) = retrofitClient.createApiService()

    @Provides
    @Singleton
    fun provideRetrofitStorage(apiService: ApiService): RetrofitStorage =
        RetrofitStorageImpl(apiService)

    @Provides
    @Singleton
    fun provideRetrofitRepository(
        retrofitStorage: RetrofitStorage,
        roomStorage: RoomStorage
    ): Repository = RetrofitRepositoryImpl(retrofitStorage, roomStorage)

}