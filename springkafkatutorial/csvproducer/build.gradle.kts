plugins {
    id("com.qiusuo.common")
    kotlin("jvm")
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
    testCompile("junit", "junit", "4.12")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}