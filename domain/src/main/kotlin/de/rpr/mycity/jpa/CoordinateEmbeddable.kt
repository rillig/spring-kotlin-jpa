package de.rpr.mycity.jpa

import de.rpr.mycity.api.CoordinateDto
import javax.persistence.Convert
import javax.persistence.Embeddable

@Embeddable
internal data class CoordinateEmbeddable(
        @Convert(converter = DoubleAttributeConverter::class) val longitude: Double,
        @Convert(converter = DoubleAttributeConverter::class) val latitude: Double) {

    private constructor() : this(0.0, 0.0)

    fun toDto(): CoordinateDto = CoordinateDto(this.longitude, this.latitude)

    companion object {

        fun origin() = CoordinateEmbeddable()

        fun fromDto(dto: CoordinateDto): CoordinateEmbeddable = CoordinateEmbeddable(dto.longitude, dto.latitude)
    }
}
