package com.qiusuo.webfluxtutorial.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;

/**
 * The reason to create custom subscription is that subscription takes the responsiblitly of scheduling as well
 * It might schedule the data into different threads.
 */
public class CustomSubscription implements Subscription {
    private Boolean cancelled;
    private final Subscriber<String> actual;
    private String myValue;

    public CustomSubscription(Subscriber<String> actual) {
        this.actual = actual;
        this.cancelled = false;
    }

    /**
     * What subscription does is to request the number of items from publisher and send it to subscriber.
     * @param var1
     */
    @Override
    public void request(long var1) {
        if(cancelled == false) {
            actual.onNext(myValue);
        }
        return ;
    }

    /**
     * What cancel does is to cancel the subscription. Maybe just mark this subscription as being cancelled.
     * So before pushing the data to subscribe, we can first check whether the subscription is already subscribed.
     */
    @Override
    public void cancel() {
        this.cancelled = true;
    }
}
