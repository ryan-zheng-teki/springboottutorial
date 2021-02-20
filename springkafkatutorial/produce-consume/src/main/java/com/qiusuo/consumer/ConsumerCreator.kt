package com.qiusuo.consumer

import com.qiusuo.topic.*
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.KafkaConsumer

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.LongDeserializer
import org.apache.kafka.common.serialization.StringDeserializer
import java.util.*


fun createConsumer(): Consumer<Long, String> {
    val props = Properties()
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKERS)
    props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID_CONFIG)
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer::class.java.getName())
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.getName())
    props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, MAX_POLL_RECORDS)
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false")
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OFFSET_RESET_EARLIER)
    val consumer: Consumer<Long, String> = KafkaConsumer<Long, String>(props)
    consumer.subscribe(Collections.singletonList(TOPIC_NAME))
    return consumer
}