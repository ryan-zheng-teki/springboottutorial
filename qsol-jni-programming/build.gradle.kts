plugins {
    id("com.qiusuo.common")
    id("org.jetbrains.kotlin.plugin.spring") version "1.4.32"
}

group = "com.qiusuo"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}