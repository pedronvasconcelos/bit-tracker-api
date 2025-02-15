package tech.vasconcelos.trackercoin.webapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["tech.vasconcelos.trackercoin"])
@EntityScan(basePackages = ["tech.vasconcelos.trackercoin"])
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
