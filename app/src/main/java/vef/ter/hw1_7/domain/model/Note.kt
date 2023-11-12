package vef.ter.hw1_7.domain.model

data class Note(
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val isDone:Boolean = false
)
