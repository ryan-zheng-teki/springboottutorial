package com.qiusuo.orderservice.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.config.TopicConfig
import org.apache.kafka.common.serialization.IntegerSerializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin
import reactor.kafka.sender.KafkaSender
import reactor.kafka.sender.SenderOptions


@Configuration
class KafkaConfiguration {
    /** This property is from by the config server. */
    @Value("#{kafka.bootstrap.servers}")
    private lateinit var bootstrapServers: String

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any> = HashMap()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        return KafkaAdmin(configs)
    }

    @Bean
    fun orderTopic(): NewTopic {
        return TopicBuilder.name(Topics.ORDER_CREATED_TOPIC.name)
            .partitions(2)
            .replicas(2)
            .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
            .build()
    }

    @Bean
    fun senderOptions(): KafkaSender<Int, String> {
        val producerProps: MutableMap<String, Any> = HashMap()
        producerProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        producerProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = IntegerSerializer::class.java
        producerProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        val senderOptions: SenderOptions<Int, String> =
            SenderOptions.create<Int, String>(producerProps).maxInFlight(1024)

        return KafkaSender.create(senderOptions)
    }
}