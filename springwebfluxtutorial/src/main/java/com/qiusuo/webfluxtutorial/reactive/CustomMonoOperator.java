package com.qiusuo.webfluxtutorial.reactive;

import org.reactivestreams.Subscriber;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;

public class CustomMonoOperator implements OptimizableOperator {
    private CorePublisher source;
    private Operator operator;

    @Override
    public CoreSubscriber subscribeOrReturn(CoreSubscriber actual) throws Throwable {
        return null;
    }

    @Override
    public CorePublisher source() {
        return this.source;
    }

    @Override
    public OptimizableOperator nextOptimizableSource() {
        return null;
    }

    @Override
    public void subscribe(CoreSubscriber subscriber) {
        if(source != null) {
            CachingSubscriber cachingSubscriber = new CachingSubscriber(subscriber);
            source.subscribe(cachingSubscriber);
        }
    }

    @Override
    public void subscribe(Subscriber subscriber) {

    }

    public void setSource(CorePublisher source) {
        this.source = source;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
