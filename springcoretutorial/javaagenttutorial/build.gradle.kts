plugins {
    kotlin("jvm")
    id("com.qiusuo.common")
}

dependencies {
    implementation(group = "org.ow2.asm", name = "asm", version = "7.0")
    implementation(group = "org.ow2.asm", name = "asm-util", version = "7.0")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.6")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.jar {
    println("Do u know what this does")
    manifest {
        attributes["Premain-Class"] = "hello.HelloWorld"
        attributes["Can-Redefine-Classes"] =  true
        attributes["Can-Retransform-Classes"] =  true
        attributes["Set-Native-Method-Prefix"] =  true
        attributes["Implementation-Title"] =  "ClassLogger"
        attributes["Implementation-Version"] = rootProject.version
    }
}