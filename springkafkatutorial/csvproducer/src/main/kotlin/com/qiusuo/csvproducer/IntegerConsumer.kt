package com.qiusuo.csvproducer

import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration
import java.util.*


fun main(args: Array<String>) {
    val properties = Properties()
    properties["bootstrap.servers"] = "localhost:9092"
    properties["key.deserializer"] = "org.apache.kafka.common.serialization.StringDeserializer"
    properties["value.deserializer"] = "org.apache.kafka.common.serialization.StringDeserializer"
    properties["group.id"] = "qa-group"
    val kafkaConsumer: KafkaConsumer<String, String> = KafkaConsumer<String, String>(properties)
    val topics: MutableList<String> = ArrayList<String>()
    topics.add("qa")
    kafkaConsumer.subscribe(topics)

    try {
        while (true) {
            val records = kafkaConsumer.poll(Duration.ofMillis(10))
            for (record in records) {
                println(
                    String.format(
                        "Topic - %s, Partition - %d, Value: %s",
                        record.topic(),
                        record.partition(),
                        record.value()
                    )
                )
            }
        }
    } catch (e: Exception) {
        println(e.message)
    } finally {
        kafkaConsumer.close()
    }
}