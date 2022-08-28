package com.qiusuo.webfluxtutorial.reactive

import reactor.core.CorePublisher
import reactor.core.CoreSubscriber
import reactor.util.annotation.Nullable

interface OptimizableOperator<IN, OUT> : CorePublisher<IN> {
    //subscribeOrReturn is the real function that subscribes the subscriber.
    @Throws(Throwable::class)
    fun subscribeOrReturn(actual: CoreSubscriber<in IN>): CoreSubscriber<in OUT>
    fun source(): CorePublisher<out OUT>

    @Nullable
    fun nextOptimizableSource(): OptimizableOperator<*, out OUT>
}
