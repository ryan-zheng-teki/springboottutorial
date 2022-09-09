plugins {
    `kotlin-dsl`
}



repositories {
    mavenCentral()
    maven { setUrl("https://plugins.gradle.org/m2/") }
    maven { setUrl("https://repo.spring.io/snapshot") }
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${project.properties["kotlin-gradle-plugin.version"]}")
    implementation("io.spring.dependency-management:io.spring.dependency-management.gradle.plugin:${project.properties["dependency.manager.plugin.version"]}")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:${project.properties["spring.boot.gradle.plugin.version"]}")
}