package com.qiusuo

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.Opcodes.ASM4


const val className = "java.lang.Integer"
const val cloneableInteface = "java/lang/Cloneable"
var reader: ClassReader = ClassReader(className)
var writer: ClassWriter = ClassWriter(reader, 0)

class AddFieldAdaptor : ClassVisitor {
    private var access: Int = org.objectweb.asm.Opcodes.ACC_PUBLIC
    private var fieldName: String
    private var isFieldPresent: Boolean = false

    constructor(fieldName: String, fieldAccess: Int, cv: ClassVisitor) : super(ASM4, cv) {
        this.cv = cv
        this.fieldName = fieldName
        this.access = fieldAccess
    }

    override fun visitField(access: Int, name: String, desc: String, signature: String, value: Any): FieldVisitor? {
        if (name.equals(fieldName)) {
            this.isFieldPresent = true
        }
        return cv.visitField(access, name, desc, signature, value)
    }

}

class ByteCodeManipulation {
}