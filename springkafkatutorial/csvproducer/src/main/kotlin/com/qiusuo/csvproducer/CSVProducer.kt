package com.qiusuo.csvproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener


@SpringBootApplication
open class CSVProducer {
    @EventListener(ApplicationReadyEvent::class)
    open fun createTopic() {
        println("hello world, I have just started up")
    }
}

fun main(args: Array<String>) {
    runApplication<CSVProducer>(*args)
}