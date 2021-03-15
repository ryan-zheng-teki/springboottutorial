package com.qiusuo.bytecode

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type

class TestClassWriter: ClassLoader() {
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
        println(value)
    }
}

fun main(args: Array<String>) {
    val testClassWriter = TestClassWriter()
    testClassWriter.run()
}