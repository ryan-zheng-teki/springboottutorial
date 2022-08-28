package com.qiusuo.webfluxtutorial.reactive

import org.reactivestreams.Subscription
import reactor.core.CoreSubscriber

class CustomSubscriber : CoreSubscriber<Any> {
    override fun onSubscribe(s: Subscription) {
        s.request(10)
    }

    override fun onNext(o: Any) {
        println("on Next")
    }

    override fun onError(throwable: Throwable) {
        println("on error")
    }

    override fun onComplete() {
        println("finishing subscribing")
    }
}
