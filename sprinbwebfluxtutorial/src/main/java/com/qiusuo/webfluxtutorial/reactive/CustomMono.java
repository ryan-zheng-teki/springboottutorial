package com.qiusuo.webfluxtutorial.reactive;

import org.reactivestreams.Subscriber;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class CustomMono implements CorePublisher {

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriber.onSubscribe(new CustomSubscription(subscriber));
    }

    @Override
    public void subscribe(CoreSubscriber subscriber) {
        subscriber.onSubscribe(new CustomSubscription(subscriber));
    }
}