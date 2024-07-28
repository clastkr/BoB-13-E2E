package bob.simple.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleSpringApplication

fun main(args: Array<String>) {
    runApplication<SimpleSpringApplication>(*args)
}
