package com.qiusuo.orderservice.services

import com.qiusuo.orderservice.model.Order
import com.qiusuo.orderservice.repositories.OrderRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
open class OrderService(private val orderRepository: OrderRepository) {
    fun createOrder(): Mono<Order> {}
}