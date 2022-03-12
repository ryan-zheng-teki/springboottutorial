import org.gradle.internal.impldep.org.eclipse.jgit.lib.ObjectChecker.type

plugins {
    id("com.qiusuo.common")
    kotlin("jvm")
}

dependencies {
    implementation(group = "org.ow2.asm", name = "asm", version = "7.0")
    implementation(group = "org.ow2.asm", name = "asm-util", version = "7.0")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.6")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

//This will add the action to the first of Jar task
tasks.jar {
    actions.forEach { println(it.toString()) }
    manifest {
        attributes["Premain-Class"] = "com.qiusuo.instrumentation.TestInstrumentation"
        attributes["Can-Redefine-Classes"] = true
        attributes["Can-Retransform-Classes"] = true
        attributes["Set-Native-Method-Prefix"] = true
        attributes["Implementation-Title"] = "TestInstrumentation"
        attributes["Implementation-Version"] = rootProject.version
    }

    from(configurations.runtimeClasspath.get().map({ if (it.isDirectory) {
        println(it.path)
        it
    }else
    {
        zipTree(it)
    }}))
}

val fatJar = task("fatJar", type = Jar::class) {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    baseName = "${project.name}-fat"
    manifest {
        attributes["Premain-Class"] = "com.qiusuo.instrumentation.TestInstrumentationKt"
        attributes["Can-Redefine-Classes"] = true
        attributes["Can-Retransform-Classes"] = true
        attributes["Set-Native-Method-Prefix"] = true
        attributes["Implementation-Title"] = "TestInstrumentation"
        attributes["Implementation-Version"] = rootProject.version
    }
    from(configurations.runtimeClasspath.get().map({ if (it.isDirectory) {
        println(it.path)
        it
    }else
    {
        zipTree(it)
    }}))
    with(tasks.jar.get() as CopySpec)
}

