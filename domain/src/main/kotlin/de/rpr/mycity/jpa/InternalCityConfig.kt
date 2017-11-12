package de.rpr.mycity.jpa

import de.rpr.mycity.jpa.CityEntity
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableJpaRepositories(basePackageClasses = arrayOf(CityRepository::class))
@EntityScan(basePackageClasses = arrayOf(CityEntity::class))
@EnableTransactionManagement
internal class InternalCityConfig
