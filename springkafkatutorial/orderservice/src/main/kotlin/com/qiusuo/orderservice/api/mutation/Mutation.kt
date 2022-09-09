package com.qiusuo.orderservice.api.mutation

import com.qiusuo.orderservice.model.Order
import com.qiusuo.orderservice.services.OrderService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
open class Mutation(private val orderService: OrderService) : GraphQLMutationResolver {
    fun createOrder(productName: String): Order {
        
    }

}