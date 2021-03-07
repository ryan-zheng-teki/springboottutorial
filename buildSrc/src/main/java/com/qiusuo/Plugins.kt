package com.qiusuo

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension
import org.gradle.api.Project
import org.springframework.boot.gradle.plugin.SpringBootPlugin

const val springCloudVersion = "Hoxton.SR8"
internal fun Project.configurePlugins() {
    pluginManager.apply(SpringBootPlugin::class.java)
    pluginManager.apply(DependencyManagementPlugin::class.java)
    extensions.getByType(StandardDependencyManagementExtension::class.java).imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
    }
}

