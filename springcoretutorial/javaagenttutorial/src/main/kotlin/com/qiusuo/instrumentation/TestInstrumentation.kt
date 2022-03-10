package com.qiusuo.instrumentation

import com.qiusuo.bytecode.CustomFieldAdder
import mu.KotlinLogging
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type
import java.lang.instrument.ClassFileTransformer
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain


private val LOGGER = KotlinLogging.logger {}

const val CLASS_NAME: String = "com.qiusuo.bytecode.TestClass"

class TestInstrumentation {
  fun premain(
    agentArgs: String, inst: Instrumentation
  ) {
    LOGGER.info("[Agent] In premain method")
    val classObj: Class<*>? = preloadClass()
    if (classObj != null) {
      transform(classObj, classObj.classLoader, inst)
    }
  }

  fun agentmain(
    agentArgs: String, inst: Instrumentation
  ) {
    LOGGER.info("[Agent] In agentmain method")
    val classObj: Class<*>? = preloadClass()
    if (classObj != null) {
      transform(classObj, classObj.classLoader, inst)
    }
  }


  private fun preloadClass(): Class<*>?  {
    try {
      return Class.forName(CLASS_NAME)
    } catch (classNotFound: ClassNotFoundException) {
      LOGGER.warn("[Agent] class not found")
    }
    return null
  }

  private fun transform(
    clazz: Class<*>,
    classLoader: ClassLoader,
    instrumentation: Instrumentation
  ) {
    val dt = AddFieldTransformer(classLoader, clazz.name)
    instrumentation.addTransformer(dt, true)
    try {
      instrumentation.retransformClasses(clazz)
    } catch (ex: Exception) {
      throw RuntimeException(
        "Transform failed for: [" + clazz.name + "]", ex
      )
    }
  }
}

/**
 * There are different bytecode manipulators. cglib, javaassist, bytebuddy. Bytebuddy and cglib both use ASM as the library
 * to perform the job. classFile -> bytecode ->
 */
class AddFieldTransformer(val classLoader: ClassLoader, val className: String) : ClassFileTransformer {
  override fun transform(
    loader: ClassLoader,
    className: String,
    classBeingRedefined: Class<*>?,
    protectionDomain: ProtectionDomain,
    classfileBuffer: ByteArray
  ): ByteArray {
    val className = "com.qiusuo.bytecode.TestClass"
    val constValue = 4
    val accessType = org.objectweb.asm.Opcodes.ACC_PUBLIC
    val name = "test"
    val fieldType = Type.INT_TYPE.toString()
    val reader = ClassReader(className)
    val writer = ClassWriter(reader, 0)
    val fieldAdder = CustomFieldAdder(accessType, name, fieldType, null, constValue, writer, Opcodes.ASM7)
    reader.accept(fieldAdder, 0)
    return writer.toByteArray()
  }
}