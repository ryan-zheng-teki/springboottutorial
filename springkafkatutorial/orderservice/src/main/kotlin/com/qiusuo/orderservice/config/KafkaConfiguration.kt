package com.qiusuo.orderservice.config

import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.common.config.TopicConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder


@Configuration
class KafkaConfiguration {
    val ORDER_CREATED_TOPIC = "OrderCreated"

    @Bean
    fun orderTopic(): NewTopic {
        return TopicBuilder.name(ORDER_CREATED_TOPIC)
            .partitions(6)
            .replicas(3)
            .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
            .build()
    }
}