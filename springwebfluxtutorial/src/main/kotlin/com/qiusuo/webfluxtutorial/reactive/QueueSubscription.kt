package com.qiusuo.webfluxtutorial.reactive

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.*

class QueueSubscription(subscriber: Subscriber<*>?) : Subscription {
    private val queuedEntities: Queue<String>
    private val parent: Subscription? = null
    private val subscriber: Subscriber<String>? = null
    override fun request(l: Long) {
        parent!!.request(l)
    }

    override fun cancel() {}

    init {
        queuedEntities = LinkedList()
    }
}
