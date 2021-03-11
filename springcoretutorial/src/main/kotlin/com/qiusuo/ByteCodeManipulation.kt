package com.qiusuo

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes.ASM4


const val className = "java.lang.Integer"
const val cloneableInteface = "java/lang/Cloneable"
var reader: ClassReader = ClassReader(className)
var writer: ClassWriter = ClassWriter(reader, 0)

class AddFieldAdaptor: ClassVisitor {
    val int access = org.objectweb.asm.Opcodes.ACC_PUBLIC
    constructor(fieldName: String, fieldDefault: String, cv: ClassVisitor): super(ASM4, cv) {}

}

class ByteCodeManipulation {
}