package de.roamingthings.dtoworkbench

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinDtoWorkbenchApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinDtoWorkbenchApplication::class.java, *args)
}
