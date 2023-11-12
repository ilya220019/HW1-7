package vef.ter.hw1_7.domain.use_cases

import vef.ter.hw1_7.domain.repository.Repository

class GetAllDoorsUseCase(private val repository: Repository) {
    suspend fun executeRequest() = repository.getDoors()
}