package de.roamingthings.dtoworkbench.person.domain

import de.roamingthings.dtoworkbench.person.api.CreatePersonDto
import de.roamingthings.dtoworkbench.person.api.PersonDto
import de.roamingthings.dtoworkbench.person.api.UpdatePersonDto
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 *
 *
 * @author Alexander Sparkowsky [info@roamingthings.de]
 * @version 2017/09/01
 */
@Entity
data class Person(
        @Id @GeneratedValue val id: Long? = null,
        val name: String,
        val birthDate: LocalDate,
        val note: String? = null
) {
    fun toDto(): PersonDto = PersonDto(
            id = this.id!!,
            name = this.name,
            birthDate = this.birthDate,
            note = this.note
    )

    fun updateFromDto(dto: UpdatePersonDto) = Person(
            id = id!!,
            name = dto.name.getOrDefault(name),
            birthDate = dto.birthDate.getOrDefault(birthDate),
            note = dto.note.getOrNullOrDefault(note)
    )

    companion object {
        fun fromDto(dto: PersonDto) = Person(
                id = dto.id,
                name = dto.name,
                birthDate = dto.birthDate,
                note = dto.note)

        fun fromDto(dto: CreatePersonDto) = Person(
                name = dto.name,
                birthDate = dto.birthDate,
                note = dto.note
        )
    }
}