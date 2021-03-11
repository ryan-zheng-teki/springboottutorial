plugins {
    java
    kotlin("jvm")
    id("com.qiusuo.common")
}

val group = "com.qiusuo"
val version = "0.0.1-SNAPSHOT"

dependencies {
    implementation("org.springframework:spring-core")
    implementation("org.springframework:spring-beans")
    implementation("org.springframework:spring-context")
    implementation(group="org.ow2.asm", name="asm", version="9.1")
    implementation(group="org.ow2.asm", name="asm-util", version="9.1")
}