package ru.quantick.kinopoisk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class KinopoiskApplication

fun main(args: Array<String>) {
	runApplication<KinopoiskApplication>(*args)
}
