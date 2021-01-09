package com.qiusuo.webfluxtutorial.reactive;

import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.util.annotation.Nullable;

public interface OptimizableOperator<IN, OUT> extends CorePublisher<IN> {

    //subscribeOrReturn is the real function that subscribes the subscriber.
    CoreSubscriber<? super OUT> subscribeOrReturn(CoreSubscriber<? super IN> actual) throws Throwable;

    CorePublisher<? extends OUT> source();

    @Nullable
    OptimizableOperator<?, ? extends OUT> nextOptimizableSource();
}
