package com.example.kotlinspringtodo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringTodoApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringTodoApplication>(*args)
}
