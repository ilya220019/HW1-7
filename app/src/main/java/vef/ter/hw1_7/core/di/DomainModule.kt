package vef.ter.hw1_7.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import vef.ter.hw1_7.domain.repository.Repository
import vef.ter.hw1_7.domain.use_cases.GetAllCamerasUseCase
import vef.ter.hw1_7.domain.use_cases.GetAllDoorsUseCase
import vef.ter.hw1_7.domain.use_cases.GetAllNotesUseCase

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideGetCameraUseCase(retrofitRepository: Repository) =
        GetAllCamerasUseCase(retrofitRepository)

    @Provides
    fun provideGetDoorsUseCase(retrofitRepository: Repository) =
        GetAllDoorsUseCase(retrofitRepository)

    @Provides
    fun provideGetAllNotesUseCase(retrofitRepository: Repository) =
        GetAllNotesUseCase(retrofitRepository)

}