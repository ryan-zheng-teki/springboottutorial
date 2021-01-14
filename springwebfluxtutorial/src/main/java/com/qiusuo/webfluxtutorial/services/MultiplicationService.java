package com.qiusuo.webfluxtutorial.services;

import reactor.core.publisher.Mono;

public class MultiplicationService {
    public Mono<Integer> multiply(Integer x, Integer y) {
        return Mono.just(x * y);
    }
}
