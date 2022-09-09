package com.qiusuo.webfluxtutorial.reactive

fun main(args: Array<String>) {
    println("i am here")
    val customMono = CustomMono("hello")
    customMono.map { x: Any? -> x }.subscribe(CustomSubscriber())
}
