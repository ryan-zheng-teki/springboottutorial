package com.qiusuo.orderservice.repositories

import com.qiusuo.orderservice.model.Order
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
open interface OrderRepository : ReactiveCrudRepository<Order, Long> {}