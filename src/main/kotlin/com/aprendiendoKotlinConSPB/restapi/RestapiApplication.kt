package com.aprendiendoKotlinConSPB.restapi

import com.aprendiendoKotlinConSPB.restapi.dao.PersonaRepositorio
import com.aprendiendoKotlinConSPB.restapi.model.persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class RestapiApplication{
}

fun main(args: Array<String>) {
	runApplication<RestapiApplication>(*args)
}
