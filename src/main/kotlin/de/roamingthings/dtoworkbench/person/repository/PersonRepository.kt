package de.roamingthings.dtoworkbench.person.repository

import de.roamingthings.dtoworkbench.person.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 *
 * @author Alexander Sparkowsky [info@roamingthings.de]
 * @version 2017/09/01
 */
@Repository
//@Transactional(Transactional.TxType.MANDATORY)
interface PersonRepository : JpaRepository<Person, Long>