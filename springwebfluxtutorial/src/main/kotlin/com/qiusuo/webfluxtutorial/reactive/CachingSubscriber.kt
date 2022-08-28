package com.qiusuo.webfluxtutorial.reactive

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.*

class CachingSubscriber(private val next: Subscriber<String>) :
    Subscriber<String>, Subscription {
    private val subscription: Subscription? = null
    private val operator: Operator<String>? = null
    private val queuedEntities: Queue<String>
    private var parent: Subscription? = null
    private val subscriber: Subscriber<String>? = null
    override fun onSubscribe(subscription: Subscription) {
        parent = subscription
        next.onSubscribe(this)
    }

    override fun onNext(s: String) {
        queuedEntities.add(s)
        if (queuedEntities.size == 4) {
            next.onNext(operator!!.operate(s))
        }
    }

    override fun onError(throwable: Throwable) {}

    /**
     * Obviously onComplete should be called by Subscription. Because subscription
     * knows when all the data are pulled.
     */
    override fun onComplete() {}
    override fun request(l: Long) {
        parent!!.request(l)
    }

    override fun cancel() {}

    init {
        queuedEntities = LinkedList()
    }
}