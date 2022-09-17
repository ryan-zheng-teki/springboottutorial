package com.qiusuo.orderservice.services

import com.qiusuo.orderservice.model.Order
import com.qiusuo.orderservice.repositories.OrderRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kafka.sender.KafkaSender
import reactor.kafka.sender.SenderRecord
import java.util.*


@Service
open class OrderService(
    private val orderRepository: OrderRepository,
    private val kafkaSender: KafkaSender<String, String>
) {
    fun createOrder(productNumber: String): Mono<Order> {
        val businessToken: String = UUID.randomUUID().toString()
        val orderId: String = UUID.randomUUID().toString()
        val order: Order = Order(businessToken, productNumber, orderId)
        orderRepository.save(order).map { order ->
            {
                val orderInfoMono = Mono.fromSupplier { order -> SenderRecord.create(topic, partition, timestamp, i, }

                kafkaSender.send(orderInfoMono)
                return order
            }
        }
    }


    fun createOrderCreatedSenderRecord(order: Order): SenderRecord<String, String>
}