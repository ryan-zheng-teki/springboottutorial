package com.qiusuo.webfluxtutorial.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSubscription implements Subscription {
    private Queue<String> queuedEntities;
    private Subscription parent;
    private Subscriber<String> subscriber;

    public QueueSubscription(Subscriber subscriber) {
        queuedEntities = new LinkedList<>();
    }
    @Override
    public void request(long l) {
        parent.request(l);
    }

    @Override
    public void cancel() {

    }
}
