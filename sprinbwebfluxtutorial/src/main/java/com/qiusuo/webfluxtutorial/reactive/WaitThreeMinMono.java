package com.qiusuo.webfluxtutorial.reactive;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

public class WaitThreeMinMono extends Mono {
    @Override
    public void subscribe(CoreSubscriber actual) {
        actual.onSubscribe(new CustomSubscription(actual));
    }
}
