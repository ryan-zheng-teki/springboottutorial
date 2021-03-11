plugins {
    id("com.google.cloud.tools.jib") version("2.7.1")
    id("com.github.johnrengelman.shadow") version("4.0.4")
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.4.0"
}


repositories {
    mavenCentral()
    maven {
        url = uri("https://packages.confluent.io/maven")
    }
}
dependencies {
    testImplementation("junit:junit:4.12")
    implementation("org.apache.kafka:kafka-clients:2.5.0")
    implementation("io.confluent:kafka-streams-avro-serde:5.5.0")
    implementation("com.sksamuel.avro4s:avro4s-core_2.13:4.0.4")
    implementation(group="org.springframework.kafka", name="spring-kafka", version="2.6.6")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0")
    // https://mvnrepository.com/artifact/org.apache.kafka/kafka

    // presentation boiler plate
    implementation("com.lihaoyi:cask_2.13:0.7.8")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("com.github.pureconfig:pureconfig_2.13:0.12.3")
    implementation("com.nrinaudo:kantan.csv-generic_2.13:0.6.1")
    implementation("com.nrinaudo:kantan.csv-java8_2.13:0.6.1")
    implementation("com.nrinaudo:kantan.csv-enumeratum_2.13:0.6.1")
    implementation(kotlin("stdlib-jdk8"))
}