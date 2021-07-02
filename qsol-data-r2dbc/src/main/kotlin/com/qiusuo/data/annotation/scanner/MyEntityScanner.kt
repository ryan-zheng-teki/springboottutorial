package com.qiusuo.data.annotation.scanner

import org.springframework.core.env.Environment
import org.springframework.core.env.StandardEnvironment
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.core.io.support.ResourcePatternResolver
import org.springframework.util.ClassUtils
import java.io.InputStreamReader
import java.io.Reader
import java.net.URL


class MyEntityScanner

fun convertClassLoaderURL(url: URL): Resource {
    return UrlResource(url)
}

fun getEnvironment(): Environment {
    return StandardEnvironment()
}

fun resolveBasePackage(basePackage: String): String {
    return ClassUtils.convertClassNameToResourcePath(getEnvironment().resolveRequiredPlaceholders(basePackage))
}

const val DEFAULT_RESOURCE_PATTERN = "**/*.class"


/**
 * PathMatchingResourcePatternResolver actually uses the ClassLoader to load the resources.
 * In Spring Application, almost all file-bases resources are loaded with ClassLoader. The
 * ClassLoader is set on the Thread. Normally the ClassLoader is the AppClassLoader which
 * is responsible to load all of our application classes.
 */
fun main(args: Array<String>) {
    val resource: Resource = ClassPathResource("application.yml")
    val inputStream = resource.inputStream
    val reader: Reader = InputStreamReader(inputStream)
    val lines = reader.readLines()
    val packageName = lines[0].split(":")[1]
    val resourceResolver = PathMatchingResourcePatternResolver()
    val packageSearchPath: String = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
            resolveBasePackage(packageName) + '/' + DEFAULT_RESOURCE_PATTERN
    val resources = resourceResolver.getResources(packageSearchPath)
    println("hello world")
}