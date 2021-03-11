package com.qiusuo

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ApplicationPlugin
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.MavenPlugin
import org.springframework.boot.gradle.plugin.SpringBootPlugin

const val springCloudVersion = "Hoxton.SR8"
internal fun Project.configurePlugins() {
    pluginManager.apply(SpringBootPlugin::class.java)
    pluginManager.apply(DependencyManagementPlugin::class.java)
    pluginManager.apply(JavaPlugin::class.java)
    pluginManager.apply(ApplicationPlugin::class.java)
    pluginManager.apply(MavenPlugin::class.java)
    extensions.getByType(StandardDependencyManagementExtension::class.java).imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

