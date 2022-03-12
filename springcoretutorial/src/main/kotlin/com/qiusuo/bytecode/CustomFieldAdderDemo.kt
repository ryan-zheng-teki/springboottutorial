package com.qiusuo.bytecode

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Path

const val CLASS_NAME: String = "com.qiusuo.bytecode.TestClass"
class TestClassWriter(urls: Array<URL>) : URLClassLoader(urls) {

    fun run() {
        val modifiedClass: Class<*> = loadClass(CLASS_NAME)
        val instance = modifiedClass.getDeclaredConstructor().newInstance()
        val value = modifiedClass.getDeclaredField("test").get(instance)
        val testMethod = modifiedClass.getDeclaredMethod("testMethod")
        testMethod.invoke(instance)
        println(value)
    }

    @Throws(ClassNotFoundException::class)
    override fun loadClass(name: String): Class<*> {
        var loadedClass = findLoadedClass(name)
        if (loadedClass == null) {
            try {
                loadedClass = findClass(name)
            } catch (e: ClassNotFoundException) {
            }
            if (loadedClass == null) {
                loadedClass = super.loadClass(name)
            }
        }
        return loadedClass
    }
}

class Application
fun main(args: Array<String>) {
    println("In main function")
}