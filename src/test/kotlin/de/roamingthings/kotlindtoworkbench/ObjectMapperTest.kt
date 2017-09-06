package de.roamingthings.kotlindtoworkbench

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import de.roamingthings.dtoworkbench.KotlinDtoWorkbenchApplication
import de.roamingthings.dtoworkbench.person.api.UpdatePersonDto
import de.roamingthings.dtoworkbench.resource.UpdateField
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
 *
 *
 * @author Alexander Sparkowsky [info@roamingthings.de]
 * @version 2017/09/05
 */
@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(KotlinDtoWorkbenchApplication::class))
@AutoConfigureJsonTesters
@JsonTest
class ObjectMapperTest {

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `should construct update dto`() {
        UpdatePersonDto(name = UpdateField.of("toni"))
    }

    @Test
    fun `should unmarshal`() {
        val parsedValue = objectMapper.readValue<UpdatePersonDto>("""
{
"name": {"value": "Toni Tester Updated"},
"birthDate": {"value": "2012-04-23T18:25:43.511Z"}
}
""")

        println(parsedValue)
    }
}