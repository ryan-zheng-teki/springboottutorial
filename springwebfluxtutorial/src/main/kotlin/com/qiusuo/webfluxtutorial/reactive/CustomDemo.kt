package com.qiusuo.webfluxtutorial.reactive

object CustomDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        println("i am here")
        val customMono = CustomMono("hello")
        customMono.map { x: Any? -> x }.subscribe(CustomSubscriber())
    }
}
