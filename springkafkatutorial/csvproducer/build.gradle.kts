plugins {
    id("com.qiusuo.common")
    id("org.jetbrains.kotlin.plugin.spring") version "1.4.32"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.kafka:spring-kafka")
}