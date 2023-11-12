package vef.ter.hw1_7.domain.use_cases

import vef.ter.hw1_7.domain.repository.Repository

class GetAllNotesUseCase (private val retrofitRepository: Repository) {

    suspend fun executeRequest() = retrofitRepository.getAllNotes()
}