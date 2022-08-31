package com.qiusuo.orderservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class OrderServiceApplication


fun main(args: Array<String>) {
    runApplication<OrderServiceApplication>(*args)
}