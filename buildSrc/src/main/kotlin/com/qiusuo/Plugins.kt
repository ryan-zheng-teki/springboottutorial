package com.qiusuo

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ApplicationPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.springframework.boot.gradle.plugin.SpringBootPlugin


const val springCloudVersion = "2021.0.3"
internal fun Project.configurePlugins() {
    pluginManager.apply(KotlinPlatformJvmPlugin::class.java)
    pluginManager.apply(ApplicationPlugin::class.java)
    pluginManager.apply(SpringBootPlugin::class.java)
    pluginManager.apply(DependencyManagementPlugin::class.java)
    extensions.getByType(StandardDependencyManagementExtension::class.java).imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

