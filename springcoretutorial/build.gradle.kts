plugins {
    kotlin("jvm")
    id("com.qiusuo.common")
}

val group = "com.qiusuo"
val version = "0.0.1-SNAPSHOT"

dependencies {
    implementation("org.springframework:spring-core")
    implementation("org.springframework:spring-beans")
    implementation("org.springframework:spring-context")

    implementation("javassist:javassist:3.12.1.GA")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.6")
    implementation(group = "org.projectlombok", name = "lombok", version = "1.18.16")
    implementation(group = "org.slf4j", name = "slf4j-simple", version = "1.6.1")
    implementation(group = "org.ow2.asm", name = "asm", version = "7.0")
    implementation(group = "org.ow2.asm", name = "asm-util", version = "7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
}

tasks.bootJar.get().enabled = false