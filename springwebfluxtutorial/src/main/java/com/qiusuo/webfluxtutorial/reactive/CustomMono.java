package com.qiusuo.webfluxtutorial.reactive;

import org.reactivestreams.Subscriber;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;


/**
 *
 */
public class CustomMono implements CorePublisher {
    private String value;

    public CustomMono(String value) {
        this.value = value;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriber.onSubscribe(new CustomSubscription(subscriber, value));
    }

    @Override
    public void subscribe(CoreSubscriber subscriber) {
        subscriber.onSubscribe(new CustomSubscription(subscriber, value));
    }

    public CustomMonoOperator map(Operator operator) {
        CustomMonoOperator monoOperator = new CustomMonoOperator();
        monoOperator.setSource(this);
        monoOperator.setOperator(operator);
        return monoOperator;
    }
}