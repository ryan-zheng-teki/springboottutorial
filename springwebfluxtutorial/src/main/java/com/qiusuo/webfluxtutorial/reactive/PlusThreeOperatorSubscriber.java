package com.qiusuo.webfluxtutorial.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class PlusThreeOperatorSubscriber implements Subscriber<String> {
    private Subscriber<String> next;
    private Subscription subscription;
    @Override
    public void onSubscribe(Subscription subscription) {
        OperatorSubscription operatorSubscription = new OperatorSubscription();
        operatorSubscription.setSource(subscription);
        this.subscription = operatorSubscription;
        next.onSubscribe(subscription);
    }

    @Override
    public void onNext(String s) {
        next.onNext(s);
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

    class OperatorSubscription implements Subscription {
        private Subscription source;

        public void setSource(Subscription source) {
            this.source = source;
        }

        @Override
        public void request(long l) {
            source.request(l);
        }

        @Override
        public void cancel() {

        }
    }
}
