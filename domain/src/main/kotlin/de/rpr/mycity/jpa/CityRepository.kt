package de.rpr.mycity.jpa

import de.rpr.mycity.jpa.CityEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
internal interface CityRepository : JpaRepository<CityEntity, String>
