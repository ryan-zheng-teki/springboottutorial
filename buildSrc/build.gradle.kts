plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    jcenter()
    maven { setUrl("https://plugins.gradle.org/m2/") }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("io.spring.dependency-management:io.spring.dependency-management.gradle.plugin:1.0.10.RELEASE")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.6.4")
}