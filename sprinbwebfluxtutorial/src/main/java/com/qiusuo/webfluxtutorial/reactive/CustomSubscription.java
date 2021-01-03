package com.qiusuo.webfluxtutorial.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;

/**
 * The reason to create custom subscription is that subscription takes the responsiblitly of scheduling as well
 * It might schedule the data into different threads.
 */
public class CustomSubscription implements Subscription {
    Boolean cancelled;
    final Subscriber<Integer> actual;

    public CustomSubscription(Subscriber<Integer> actual) {
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
            actual.onNext(12);
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
