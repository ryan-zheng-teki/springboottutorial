package com.qiusuo

import org.gradle.api.Plugin
import org.gradle.api.Project

class QiuSuoPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configurePlugins()
        target.configureRepositories()
    }
}
