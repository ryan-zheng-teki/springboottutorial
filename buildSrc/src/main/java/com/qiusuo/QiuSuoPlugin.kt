package com.qiusuo

import org.gradle.api.Plugin
import org.gradle.api.Project

class QiuSuoPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.task("hello")
            .doLast { println("My first build sc") }
        target.configurePlugins()
        target.configureRepositories()
    }
}
