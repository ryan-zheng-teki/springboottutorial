package com.qiusuo.bytecode

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type

fun main(args: Array<String>) {
    val className = "com.qiusuo.bytecode.TestClass"
    val constValue : Int = Integer.valueOf(5)
    val accessType = org.objectweb.asm.Opcodes.ACC_PUBLIC
    val name = "test"
    val dataType = Type.INT.toString()
    val reader: ClassReader = ClassReader(className)
    val writer: ClassWriter = ClassWriter(reader, 0)
    val fieldAdder = CustomFieldAdder(accessType, name, dataType, null, constValue, writer, Opcodes.ASM9)
    writer.toByteArray()
}