package vef.ter.hw1_7.domain.model

data class CameraModel(
    var `data`: Data,
    var success: Boolean
) {
    data class Data(
        var cameras: List<Camera>,
        val room: List<String>
    ) {
        data class Camera(
            val favorites: Boolean,
            val id: Int,
            val name: String,
            val rec: Boolean,
            val room: String,
            val snapshot: String
        )
    }
}