package net.dlcruz.springboot.console.template

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConsoleApplication

fun main(args: Array<String>) {
    runApplication<ConsoleApplication>(*args)
}
