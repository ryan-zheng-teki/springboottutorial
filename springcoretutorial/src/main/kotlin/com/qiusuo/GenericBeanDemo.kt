package com.qiusuo

import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.beans.factory.support.GenericBeanDefinition

data class ABean(val name: String) {
    constructor() : this("")
}


fun main(args: Array<String>) {
    val genericBeanDefinition: GenericBeanDefinition = GenericBeanDefinition()
    genericBeanDefinition.beanClass = ABean::class.java
    val context: DefaultListableBeanFactory = DefaultListableBeanFactory()
    context.registerBeanDefinition("aBean", genericBeanDefinition)
    val bean: ABean = context.getBean(ABean::class.java)
    println(bean.name)
}