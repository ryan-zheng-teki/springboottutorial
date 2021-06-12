package com.qiusuo.data.annotation.scanner

import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import java.io.InputStreamReader
import java.io.Reader


class MyEntityScanner {

}

fun main(args: Array<String>) {
    val resource: Resource = ClassPathResource("application.yml")
    val inputStream = resource.inputStream
    val reader: Reader = InputStreamReader(inputStream)
    val lines = reader.readLines()
    println(lines)
}