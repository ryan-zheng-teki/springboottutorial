package com.qiusuo.webfluxtutorial.reactive;

import org.reactivestreams.Subscription;

public class CustomDemo {
    public static void main(String[] args) {
        System.out.println("i am here");

        CustomMono customMono = new CustomMono("hello");
        customMono.map((x) -> x).subscribe(new CustomSubscriber());
    }
}
