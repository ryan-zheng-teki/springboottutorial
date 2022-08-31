package com.qiusuo.orderservice.api.mutation

import com.qiusuo.orderservice.model.Order
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.context.annotation.Configuration

@Configuration
open class Mutation(val orderService: OrderService) : GraphQLMutationResolver {


    fun createOrder(productName: String): Order {

    }

}