package vef.ter.hw1_7.data.storage.model

data class DoorModelDTO(
    val `data`: List<Data>,
    val success: Boolean
) {
    data class Data(
        val favorites: Boolean,
        val id: Int,
        val name: String,
        val room: String,
        val snapshot: String
    )
}