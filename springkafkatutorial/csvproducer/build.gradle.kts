plugins {
    id("com.qiusuo.common")
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.spring") version "1.4.32"
}

group = "com.qiusuo"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation(kotlin("stdlib"))
    implementation("org.springframework.kafka:spring-kafka")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}