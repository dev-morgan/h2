package com.sample.h2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class H2App

fun main(args: Array<String>) {
    runApplication<H2App>(*args)
}
