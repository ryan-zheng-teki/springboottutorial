package com.qiusuo.webfluxtutorial.facade;

import com.qiusuo.webfluxtutorial.services.MultiplicationService;
import reactor.core.publisher.Mono;

public class MultiplicationFacade {
    private MultiplicationService multiplicationService;

    public Mono multiply(Integer a, Integer b) {
        multiplicationService.multiply(a, b).subscribe(x -> System.out.println(x));
        return Mono.empty();
    }
}
