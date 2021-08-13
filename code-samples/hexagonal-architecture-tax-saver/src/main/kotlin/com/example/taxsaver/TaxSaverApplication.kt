package com.example.taxsaver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaxSaverApplication

fun main(args: Array<String>) {
    runApplication<TaxSaverApplication>(*args)
}
