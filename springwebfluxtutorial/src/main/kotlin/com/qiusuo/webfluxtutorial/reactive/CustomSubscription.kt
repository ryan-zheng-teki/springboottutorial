package com.qiusuo.webfluxtutorial.reactive

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


/**
 * The reason to create custom subscription is that subscription takes the responsiblitly of scheduling as well
 * It might schedule the data into different threads. Normally when the subscription
 * is being created, it knows how to use the publisher to get data.
 */
class CustomSubscription(private val actual: Subscriber<String>, private val value: String) :
    Subscription {
    private var cancelled = false

    /**
     * What subscription does is to request the number of items from publisher and send it to subscriber.
     * @param var1
     */
    override fun request(var1: Long) {
        if (cancelled == false) {
            actual.onNext(value)
        }
        return
    }

    /**
     * What cancel does is to cancel the subscription. Maybe just mark this subscription as being cancelled.
     * So before pushing the data to subscribe, we can first check whether the subscription is already subscribed.
     */
    override fun cancel() {
        cancelled = true
    }
}
