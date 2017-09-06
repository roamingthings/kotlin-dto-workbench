package de.roamingthings.dtoworkbench.person.api

import de.roamingthings.dtoworkbench.resource.UpdateField
import de.roamingthings.dtoworkbench.resource.UpdateNullableField
import java.time.LocalDate

/**
 * @author Alexander Sparkowsky [info@roamingthings.de]
 * @version 2017/09/01
 */
data class PersonDto(
        val id: Long,
        val name: String,
        val birthDate: LocalDate,
        val note: String?
)

data class CreatePersonDto(
        val name: String,
        val birthDate: LocalDate,
        val note: String? = null
)

data class UpdatePersonDto(
        val name: UpdateField<String> = UpdateField.ignore(),
        val birthDate: UpdateField<LocalDate> = UpdateField.ignore(),
        val note: UpdateNullableField<String> = UpdateNullableField.ignore()
)