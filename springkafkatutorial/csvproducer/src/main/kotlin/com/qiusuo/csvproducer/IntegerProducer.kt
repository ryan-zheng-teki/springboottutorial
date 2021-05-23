package com.qiusuo.csvproducer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.KafkaException
import org.apache.kafka.common.errors.ProducerFencedException
import java.util.*


fun main(args: Array<String>) {
    val properties = Properties()
    properties["bootstrap.servers"] = "127.0.0.1:9092"
    properties["enable.idempotence"] = "true"
    properties["key.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
    properties["value.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
    //we can actually use a uuid generator to generate one transactional id
    properties["transactional.id"] = "integer-producer-0000" // This ID must be unique across the diff producers

    val kafkaProducer: KafkaProducer<String, String> = KafkaProducer<String, String>(properties)
    //It's easy to understand transactions. Even for a cache system, we could design transactions.
    kafkaProducer.initTransactions()
    try {
        kafkaProducer.beginTransaction()
        for (i in 1..100)
            kafkaProducer.send(ProducerRecord("qa", i.toString(), i.toString()))
        kafkaProducer.commitTransaction()
    } catch (e: ProducerFencedException) {
        // We can't recover from these exceptions, so our only option is to close the producer and exit.
        kafkaProducer.close()
    } catch (e: KafkaException) {
        // For all other exceptions, just abort the transaction and try again.
        kafkaProducer.abortTransaction()
    }
    kafkaProducer.close()
}