package com.qiusuo.producer

import com.qiusuo.topic.CLIENT_ID
import com.qiusuo.topic.KAFKA_BROKERS
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.LongSerializer
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

fun createProducer(): Producer<Long, String> {
    val props: Properties = Properties()
    props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = KAFKA_BROKERS
    props[ProducerConfig.CLIENT_ID_CONFIG] = CLIENT_ID
    props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = LongSerializer::class.java.getName()
    props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.getName()
    return KafkaProducer(props)
}