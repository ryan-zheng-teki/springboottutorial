package com.qiusuo.webfluxtutorial.reactive

fun interface Operator<T> {
    fun operate(t: T): T
}
