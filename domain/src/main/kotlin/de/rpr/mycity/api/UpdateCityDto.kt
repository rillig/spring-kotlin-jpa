package de.rpr.mycity.api

data class UpdateCityDto(
        val name: String?,
        val description: String?,
        val location: CoordinateDto?)
