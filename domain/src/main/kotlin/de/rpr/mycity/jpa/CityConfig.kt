package de.rpr.mycity.jpa

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = arrayOf(InternalCityConfig::class))
class CityConfig
