package com.qiusuo

import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.beans.factory.support.GenericBeanDefinition

data class ABean(val name: String)



fun generateFactoryBean() {
    val genericBeanDefinition: GenericBeanDefinition = GenericBeanDefinition()
    genericBeanDefinition.beanClass = ABean::class.java
    val context: DefaultListableBeanFactory = DefaultListableBeanFactory()
    context.registerBeanDefinition("aBean", genericBeanDefinition)

    //method one: use class type to get bean
    val bean: ABean = context.getBean(ABean::class.java)
}

fun generateNormalBean() {

}

fun generateRootBean() {

}

fun main(args: Array<String>) {
}