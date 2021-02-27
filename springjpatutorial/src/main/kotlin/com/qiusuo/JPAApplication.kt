package com.qiusuo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class JPAApplication

fun main(args: Array<String>) {
    runApplication<JPAApplication>(*args)
}