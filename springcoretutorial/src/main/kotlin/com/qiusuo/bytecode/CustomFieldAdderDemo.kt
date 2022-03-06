package com.qiusuo.bytecode

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Path

class TestClassWriter: URLClassLoader {
    fun run() {
        val className = "com.qiusuo.bytecode.TestClass"
        val constValue = 4
        val accessType = org.objectweb.asm.Opcodes.ACC_PUBLIC
        val name = "test"
        val fieldType = Type.INT_TYPE.toString()
        val reader = ClassReader(className)
        val writer = ClassWriter(reader, 0)
        val fieldAdder = CustomFieldAdder(accessType, name, fieldType, null, constValue, writer, Opcodes.ASM7)
        reader.accept(fieldAdder, 0)
        val modified =  writer.toByteArray()
        val modifiedClass: Class<*> = defineClass(className, modified, 0, modified.size)
        val instance = modifiedClass.getDeclaredConstructor().newInstance()
        val value = modifiedClass.getDeclaredField("test").get(instance)
        val testMethod = modifiedClass.getDeclaredMethod("testMethod")
        testMethod.invoke(instance)
        println(value)
    }

    @Throws(ClassNotFoundException::class)
    override fun loadClass(name: String): Class<*> {
        // First check whether it's already been loaded, if so use it
        var loadedClass = findLoadedClass(name)

        // Not loaded, try to load it
        if (loadedClass == null) {
            try {
                // Ignore parent delegation and just try to load locally
                loadedClass = findClass(name)
            } catch (e: ClassNotFoundException) {
                // Swallow exception - does not exist locally
            }

            // If not found locally, use normal parent delegation in URLClassloader
            if (loadedClass == null) {
                // throws ClassNotFoundException if not found in delegation hierarchy at all
                loadedClass = super.loadClass(name)
            }
        }
        // will never return null (ClassNotFoundException will be thrown)
        return loadedClass
    }

    constructor(urls: Array<URL>): super(urls)

}

fun main(args: Array<String>) {
    val url = Path.of("/home/ryan/Learning/springboottutorial/springcoretutorial/build/classes/kotlin/main").toUri().toURL()
    var urls = arrayOf(url)
    val testClassWriter = TestClassWriter(urls)
    testClassWriter.run()
}