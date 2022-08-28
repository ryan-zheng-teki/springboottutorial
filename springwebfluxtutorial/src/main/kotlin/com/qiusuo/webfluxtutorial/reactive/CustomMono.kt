package com.qiusuo.webfluxtutorial.reactive

import org.reactivestreams.Subscriber
import reactor.core.CorePublisher
import reactor.core.CoreSubscriber

class CustomMono(private val value: String) : CorePublisher<Any> {
    fun requestDB(): List<String> {
        return ArrayList()
    }

    fun subscribe(subscriber: Subscriber<*>) {
        subscriber.onSubscribe(CustomSubscription(subscriber, value))
    }

    fun subscribe(subscriber: CoreSubscriber<*>) {
        subscriber.onSubscribe(CustomSubscription(subscriber, value))
    }

    fun map(operator: Operator<*>?): CustomMonoOperator {
        val monoOperator = CustomMonoOperator()
        monoOperator.setSource(this)
        monoOperator.setOperator(operator)
        return monoOperator
    }
}