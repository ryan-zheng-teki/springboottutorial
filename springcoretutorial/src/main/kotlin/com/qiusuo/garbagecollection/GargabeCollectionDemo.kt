package com.qiusuo.garbagecollection

import lombok.extern.slf4j.Slf4j
import mu.KotlinLogging
import java.util.*
import kotlin.collections.HashMap



private val logger = KotlinLogging.logger {}


class Product(val price: Int, val name: String): Object() {
    override fun finalize() {
        logger.info {"finalize is called in thread ${Thread.currentThread().name} for product $name"}
        super.finalize()
    }
}


class Order(val name: String): Object() {
    override fun finalize() {
        logger.info {"finalize is called in thread ${Thread.currentThread().name} for order $name"}
        super.finalize()
    }
}

fun main(args: Array<String>) {
    localVariableOnHeap()
    System.gc()
    Thread.sleep(2000)

    val strongMap = mapForObjects()
    System.out.println(strongMap.get(3)?.name)
    System.gc()
    Thread.sleep(2000)

    val weakMap = weakMapForObjects()
    weakMap.forEach({
        System.out.println(it.key.name)
    })

    System.gc()
    Thread.sleep(4000)
}

fun localVariableOnHeap() {
    val product = Product(12, "localVariableProduct")
    System.out.println(product.name)
}

fun mapForObjects(): Map<Int, Product> {
    val map = HashMap<Int, Product>()
    val productOne =  Product(1, "strongMapProductOne")
    val productTwo = Product(2, "strongMapProductTwo")
    map.put(1, productOne)
    map.put(2, productTwo)
    return map
}

fun weakMapForObjects(): Map<Product, Order> {
    val map = WeakHashMap<Product, Order>()
    val productOne = Product(1, "weakMapProductKey")
    val orderOne = Order("weakMapOrderValue")

    map[productOne] = orderOne
    return map
}