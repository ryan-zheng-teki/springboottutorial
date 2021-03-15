package com.qiusuo.bytecode

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.Opcodes.V11


class Foo(val name: String) {
    fun foo() {
        print("foo")
    }
}

class TestClass {
    fun testMethod() {
        val foo: Foo = Foo("yogi")
    }
}

class CustomFieldAdder(val access: Int, val name: String, val fieldType: String, val signature: String?, val value: Int, val cv: ClassVisitor, val api: Int): ClassVisitor(api, cv) {
    var isFieldPresent = false
    override fun visitField(access: Int, name: String?, desc: String?, signature: String?, value: Any?): FieldVisitor? {
        if(name.equals(this.name)) {
            isFieldPresent = true
        }
        return cv.visitField(access, name, desc, signature, value)
    }

    override fun visitEnd() {
        if (!isFieldPresent) {
            val fv = cv.visitField(access, name, fieldType, null, value)
            fv?.visitEnd()
        }
        cv.visitEnd()
    }
}