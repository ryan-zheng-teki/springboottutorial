plugins {
    java
    kotlin("jvm") version "1.4.30"
}

val group = "com.qiusuo"
val version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-core")
    implementation("org.springframework:spring-beans")
    implementation("org.springframework:spring-context")
}