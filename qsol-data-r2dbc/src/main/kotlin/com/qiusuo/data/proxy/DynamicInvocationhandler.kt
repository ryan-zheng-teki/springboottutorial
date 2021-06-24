package com.qiusuo.data.proxy

import mu.KotlinLogging
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

private val logger = KotlinLogging.logger {}


class DynamicInvocationHandler : InvocationHandler {
    override fun invoke(p0: Any?, p1: Method?, p2: Array<out Any>?) {
        println("nothing to be done here")
    }
}

fun main(args: Array<String>) {
    var proxyInstance = (Proxy.newProxyInstance(
            DynamicInvocationHandler::class.java.getClassLoader(), arrayOf<Class<*>>(MutableMap::class.java),
            DynamicInvocationHandler()) as MutableMap<String, String>)
    proxyInstance["hello"] = "jack"
    

}


