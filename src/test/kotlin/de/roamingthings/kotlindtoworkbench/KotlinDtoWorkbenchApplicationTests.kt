package de.roamingthings.kotlindtoworkbench

import de.roamingthings.dtoworkbench.KotlinDtoWorkbenchApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(KotlinDtoWorkbenchApplication::class))
@DataJpaTest
class KotlinDtoWorkbenchApplicationTests {

	@Test
	fun contextLoads() {
	}

}
