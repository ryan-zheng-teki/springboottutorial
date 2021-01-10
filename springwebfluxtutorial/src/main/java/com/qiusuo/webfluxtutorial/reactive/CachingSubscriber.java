package com.qiusuo.webfluxtutorial.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.LinkedList;
import java.util.Queue;

public class CachingSubscriber implements Subscriber<String>, Subscription {
    private Subscriber<String> next;
    private Subscription subscription;
    private Operator<String> operator;

    private Queue<String> queuedEntities;
    private Subscription parent;
    private Subscriber<String> subscriber;

    public CachingSubscriber(Subscriber<String> next) {
        this.next = next;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.parent = subscription;
        next.onSubscribe(this);
    }

    @Override
    public void onNext(String s) {
        queuedEntities.add(s);

        if(queuedEntities.size() == 4) {
            next.onNext(operator.operate(s));
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    /**
     *  Obviously onComplete should be called by Subscription. Because subscription
     *  knows when all the data are pulled.
     */
    @Override
    public void onComplete() {

    }

    @Override
    public void request(long l) {
        parent.request(l);
    }

    @Override
    public void cancel() {

    }
}
