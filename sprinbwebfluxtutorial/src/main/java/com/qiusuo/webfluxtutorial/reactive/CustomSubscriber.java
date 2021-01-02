package com.qiusuo.webfluxtutorial.reactive;

import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;

public class CustomSubscriber implements CoreSubscriber {
    @Override
    public void onSubscribe(Subscription s) {
        s.request(10);
    }

    @Override
    public void onNext(Object o) {
        System.out.println("on Next");
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("on error");
    }

    @Override
    public void onComplete() {
        System.out.println("finishing subscribing");
    }
}
