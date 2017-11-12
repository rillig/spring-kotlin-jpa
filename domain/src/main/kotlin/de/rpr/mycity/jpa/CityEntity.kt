package de.rpr.mycity.jpa

import de.rpr.mycity.api.CityDto
import de.rpr.mycity.api.CreateCityDto
import de.rpr.mycity.api.UpdateCityDto
import java.time.LocalDateTime
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "city")
internal data class CityEntity(
        @Id val id: String? = null,
        val name: String,
        val description: String? = null,
        @Embedded val location: CoordinateEmbeddable,
        val updatedAt: LocalDateTime = LocalDateTime.now(),
        val createdAt: LocalDateTime = LocalDateTime.now()) {

    // Default constructor for JPA
    @Suppress("unused")
    private constructor() : this(
            name = "",
            location = CoordinateEmbeddable.origin(),
            updatedAt = LocalDateTime.MIN)

    companion object {

        fun fromDto(dto: CityDto) = CityEntity(
                id = dto.id,
                name = dto.name,
                description = dto.description,
                location = CoordinateEmbeddable.fromDto(dto.location),
                updatedAt = dto.updatedAt,
                createdAt = dto.createdAt)

        fun fromDto(dto: CreateCityDto) = CityEntity(
                id = dto.id,
                name = dto.name,
                description = dto.description,
                location = CoordinateEmbeddable(dto.location.longitude, dto.location.latitude))

        fun fromDto(dto: UpdateCityDto, defaultCity: CityEntity) = CityEntity(
                id = defaultCity.id!!,
                name = dto.name ?: defaultCity.name,
                description = dto.description ?: defaultCity.description,
                location = if (dto.location != null) CoordinateEmbeddable.fromDto(dto.location) else defaultCity.location,
                updatedAt = LocalDateTime.now(),
                createdAt = defaultCity.createdAt)

    }

}

internal fun CityEntity.toDto(): CityDto = CityDto(
        id = this.id!!,
        name = this.name,
        description = this.description,
        location = this.location.toDto(),
        updatedAt = this.updatedAt,
        createdAt = this.createdAt
)
