package com.qiusuo

import com.qiusuo.producer.createProducer
import com.qiusuo.topic.TOPIC_NAME
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord


fun main(args: Array<String>) {
    runProducer()
}

fun runProducer() {
    val producer: Producer<Long, String> = createProducer()
    for (index in 0 until 10) {
        val record: ProducerRecord<Long, String> = ProducerRecord<Long, String>(TOPIC_NAME, "This is record ")
        val metadata = producer.send(record).get()
        println("print the message")
    }
}