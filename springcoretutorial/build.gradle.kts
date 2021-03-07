plugins {
    java
    kotlin("jvm")
    id("com.qiusuo.common")
}

val group = "com.qiusuo"
val version = "0.0.1-SNAPSHOT"

dependencies {
    implementation("org.springframework:spring-core")
    implementation("org.springframework:spring-beans")
    implementation("org.springframework:spring-context")
}