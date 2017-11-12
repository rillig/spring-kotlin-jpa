package de.rpr.mycity.api

data class CoordinateDto(
        val longitude: Double,
        val latitude: Double) {

    companion object {
        fun origin() = CoordinateDto(0.0, 0.0)
    }
}
