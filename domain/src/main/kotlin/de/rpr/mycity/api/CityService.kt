package de.rpr.mycity.api

interface CityService {

    fun retrieveCity(cityId: String): CityDto?

    fun retrieveCities(): List<CityDto>

    fun addCity(city: CreateCityDto): CityDto

    fun updateCity(id: String, city: UpdateCityDto): CityDto?
}
