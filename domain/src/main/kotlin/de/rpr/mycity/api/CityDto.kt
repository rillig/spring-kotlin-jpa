package de.rpr.mycity.api

import java.time.LocalDateTime

data class CityDto(
        var id: String,
        var name: String,
        var description: String? = null,
        var location: CoordinateDto,
        var updatedAt: LocalDateTime,
        var createdAt: LocalDateTime)
