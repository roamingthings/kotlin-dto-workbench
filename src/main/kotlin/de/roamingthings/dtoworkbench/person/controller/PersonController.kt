package de.roamingthings.dtoworkbench.person.controller

import de.roamingthings.dtoworkbench.person.api.CreatePersonDto
import de.roamingthings.dtoworkbench.person.api.PersonDto
import de.roamingthings.dtoworkbench.person.api.UpdatePersonDto
import de.roamingthings.dtoworkbench.person.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 *
 *
 * @author Alexander Sparkowsky [info@roamingthings.de]
 * @version 2017/09/01
 */
@RestController
@RequestMapping(
        value = "/persons",
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
)
class PersonController(val personService: PersonService) {

    @GetMapping
    fun retrieveAll(uriBuilder: UriComponentsBuilder): ResponseEntity<List<PersonDto>> {
        val persons = personService.retrieveAllPersons()
        return ResponseEntity.ok(persons)
    }

    @GetMapping("/{id}")
    fun retrieveOne(@NotNull @PathVariable("id") id: Long, uriBuilder: UriComponentsBuilder): ResponseEntity<PersonDto>{
        val person = personService.retrievePerson(id)

        return if (person != null) ResponseEntity.ok(person) else ResponseEntity.status(HttpStatus.NOT_FOUND).build()

    }

    @PostMapping(consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createPerson(@Valid @RequestBody createRequest: CreatePersonDto, uriBuilder: UriComponentsBuilder): ResponseEntity<Unit> {
        val createdPerson = personService.createPerson(createRequest)

        return ResponseEntity
                .created(uriBuilder.path("persons/{id}")
                        .buildAndExpand(createdPerson.id).toUri())
                .build()
    }

    @PutMapping(value = "{id}", consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun updateCategory(@NotNull @PathVariable("id") id: Long, @RequestBody updateRequest: UpdatePersonDto, uriBuilder: UriComponentsBuilder): ResponseEntity<Void> {
        val updatedPerson = personService.updatePerson(id, updateRequest)

        return if (updatedPerson != null) {
            return ResponseEntity
                    .created(uriBuilder.path("persons/{id}")
                            .buildAndExpand(updatedPerson.id).toUri())
                    .build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deletePerson(@NotNull @PathVariable("id") id: Long): ResponseEntity<Unit> {
        personService.deletePerson(id)

        return ResponseEntity.noContent().build()
    }
}