package com.qiusuo

import org.gradle.api.Project

internal fun Project.configureRepositories() {
    repositories.mavenLocal()
    repositories.mavenCentral()
    repositories.gradlePluginPortal()
}