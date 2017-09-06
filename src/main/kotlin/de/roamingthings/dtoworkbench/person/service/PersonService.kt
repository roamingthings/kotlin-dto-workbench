package de.roamingthings.dtoworkbench.person.service

import de.roamingthings.dtoworkbench.person.api.CreatePersonDto
import de.roamingthings.dtoworkbench.person.api.PersonDto
import de.roamingthings.dtoworkbench.person.api.UpdatePersonDto
import de.roamingthings.dtoworkbench.person.domain.Person
import de.roamingthings.dtoworkbench.person.repository.PersonRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

/**
 * @author Alexander Sparkowsky [info@roamingthings.de]
 * @version 2017/09/01
 */
@Service
@Transactional
class PersonService(val personRepository: PersonRepository) {
    fun retrieveAllPersons(): List<PersonDto> = personRepository.findAll().map { it.toDto() }

    fun createPerson(personDto: CreatePersonDto): PersonDto = personRepository.save(Person.fromDto(personDto)).toDto()

    fun retrievePerson(id: Long): PersonDto? = personRepository.findById(id).orElse(null).toDto()

    fun deletePerson(id: Long) = personRepository.findById(id).ifPresent { personRepository.delete(it) }

    fun updatePerson(id: Long, updateRequest: UpdatePersonDto): PersonDto? {
        return personRepository.findById(id).map { currentPerson ->
            personRepository.save(currentPerson.updateFromDto(updateRequest)).toDto()
        }.orElse(null)
    }

/*
    fun retrievePerson(id: Long): PersonDto? = personRepository.findOne(id)?.toDto()

    fun deletePerson(id: Long) = personRepository.delete(id)

    fun updatePerson(id: Long, updateRequest: UpdatePersonDto): PersonDto? {
        val personToUpdate = personRepository.findOne(id)

        return if (personToUpdate != null) personRepository.save(personToUpdate.updateFromDto(updateRequest)).toDto()
        else null
    }
*/
}