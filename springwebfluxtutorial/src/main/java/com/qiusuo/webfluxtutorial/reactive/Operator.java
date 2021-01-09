package com.qiusuo.webfluxtutorial.reactive;

@FunctionalInterface
public interface Operator<T> {
    T operate(T t );
}
