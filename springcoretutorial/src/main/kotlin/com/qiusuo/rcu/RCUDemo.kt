package com.qiusuo.rcu

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

//I just defined a linked list
data class Node(var prev: Node?, var next: Node?, var value: Int)

fun initializeList() {
    lateinit var head: Node

    //we have initialized a double linked list
    for (i in 1..4) {
        if (head == null) {
            head = Node(null, null, i)
        }
        var newNode: Node = Node(null, null, i)
        newNode.next = head
        head.prev = newNode
        head = newNode
    }
    var test = { number: Int -> number % 2 == 0 }

    GlobalScope.launch {
        var currentNode = head
        if (test(currentNode.value)) {

        }
    }
    //next we want to create thread coroutines to access the linked list
}

/** create a coroutine that fetches node that mathes the condition, and change the value
 *
 **/
private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    GlobalScope.launch {
        // launch a new coroutine in background and continue
        logger.info { "thread name global scope is  ${Thread.currentThread().id}" }
        delay(1000L)
        println("World!")
    }
    println("Hello,") // main thread continues here immediately
    logger.info { "thread name is  ${Thread.currentThread().id}" }
    runBlocking {
        logger.info { "thread name coroutine scope is  ${Thread.currentThread().id}" }
        // but this expression blocks the main thread
        delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
    }
}