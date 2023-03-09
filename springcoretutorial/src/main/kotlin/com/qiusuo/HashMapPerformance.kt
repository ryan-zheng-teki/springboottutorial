package com.qiusuo

import java.lang.reflect.Field
import kotlin.random.Random


class HashMapPerformance {

}

fun generateRandomString(): String {
    val leftLimit = 97 // letter 'a'

    val rightLimit = 122 // letter 'z'

    val targetStringLength = 26
    val random = Random.Default


    val stringBuilder = StringBuilder()
    var count = 1
    while (count <= targetStringLength) {
        stringBuilder.append(random.nextInt(leftLimit, rightLimit + 1).toChar())
        count++
    }
    return stringBuilder.toString()
}

data class People(val name: String, val age: Int)

fun main(args: Array<String>) {

    val storedKey = arrayOfNulls<String>(5)
    val constant = "dhalfdas"

    val people: People = People("hello", 23)
    val hashMap = HashMap<String, People>()
    val hashSet = HashSet<String>()
    val numberOfStrings = 3000000
    var count = 0
    while (count < numberOfStrings) {
        val output = generateRandomString()
        hashMap.put(output, people)
        count++
    }

    val field: Field = hashMap.javaClass.getDeclaredField("table")
    field.setAccessible(true)
    val value = field.get(hashMap)

    print("see the size of hashmap")

}