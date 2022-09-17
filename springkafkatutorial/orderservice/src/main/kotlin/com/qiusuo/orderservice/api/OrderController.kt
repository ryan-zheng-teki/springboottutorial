package com.qiusuo.orderservice.api

import com.qiusuo.orderservice.model.Order
import com.qiusuo.orderservice.services.OrderService
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono

@Controller
open class OrderController(private val orderService: OrderService) {
    @QueryMapping
    fun createOrder(productName: String): Mono<Order> {
        return orderService.createOrder(productName)
    }
}